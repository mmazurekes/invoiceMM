package mazurek.run.controller;

import mazurek.run.logic.InvoiceService;
import mazurek.run.logic.MyCustomTypeEditor;
import mazurek.run.model.Invoice;
import mazurek.run.model.InvoiceReadModel;
import mazurek.run.model.InvoiceWriteModel;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/my")
public class MyController {

    InvoiceService invoiceService;




    public MyController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(value = "/abc/{value}")
    public LocalDateTime parseExoticType(
            @PathVariable("value") LocalDateTime ldt) {
        return ldt;
    }

    @GetMapping(value = "/123")
    String showInvoices(Model model){
        List<InvoiceReadModel> irms = invoiceService.readAll();
        model.addAttribute("invoices", irms);

        return "tabsInvoice";
    }



    @PostMapping(value = "/xyz")
    String showInvoicesXYZ(Model model,
                        @ModelAttribute("invoice") InvoiceWriteModel iwm){
        List<InvoiceReadModel> irms = invoiceService.readAll();
        model.addAttribute("invoices", irms);
        return "modaltest";
    }


    @PostMapping
    String insertTask(Model model,
                      //String invoiceNumber ,
                      //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime purchaseDate,
                      //String description,
                      //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
                      @ModelAttribute("invoice") InvoiceWriteModel iwm

    ){
        System.out.println(iwm.getPurchaseDate());
        //LocalDateTime dateTime = LocalDateTime.parse(purchaseDate);
        //invoiceService.createInvoice( new InvoiceWriteModel(invoiceNumber, purchaseDate ,description) );
        model.addAttribute("invoices",  invoiceService.readAll());
        return "modaltest";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor( LocalDateTime.class,
                new MyCustomTypeEditor()
        );
    }




//    @InitBinder
//    private void dateBinder(WebDataBinder binder) {
//        System.out.println("test");
//        //The date format to parse or output your dates
//       //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm");
//
//        //Create a new CustomDateEditor
//        //CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
//        //Register it as custom editor for the Date type
//        //binder.registerCustomEditor(LocalDateTime.class, editor);
//        binder.registerCustomEditor( LocalDateTime.class, new PropertyEditorSupport() {
//            @Override
//            public void setAsText( String text ) throws IllegalArgumentException{
//                setValue(
//                    LocalDateTime.parse( text, DateTimeFormatter.ISO_DATE_TIME )
//                );
//            }
//            @Override
//            public String getAsText()  {
//                String myDateTime = (String) getValue();
//                System.out.println(myDateTime);
//                return  myDateTime + "sssssssssss";
//            }
//
//
//        } );
//
//    }

}

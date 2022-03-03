package mazurek.run.controller;

import mazurek.run.logic.InvoiceService;
import mazurek.run.model.Invoice;
import mazurek.run.model.InvoiceReadModel;
import mazurek.run.model.InvoiceWriteModel;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/my")
public class MyController {

    InvoiceService invoiceService;




    public MyController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    String showInvoices(Model model){
        List<InvoiceReadModel> irms = invoiceService.readAll();
        model.addAttribute("invoices", irms);
        return "modaltest";
    }
    @PostMapping
    String insertTask(Model model,
                      String invoiceNumber ,
                      @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime purchaseDate,
                      String description,

                      @ModelAttribute("invoice") InvoiceWriteModel iwm

    ){

        invoiceService.createInvoice( new InvoiceWriteModel(invoiceNumber,purchaseDate,description) );
        model.addAttribute("invoices",  invoiceService.readAll());
        return "modaltest";
    }

}

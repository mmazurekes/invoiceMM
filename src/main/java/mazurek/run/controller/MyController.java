package mazurek.run.controller;

import mazurek.run.logic.InvoiceService;
import mazurek.run.model.InvoiceReadModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "invoices";
    }
}

package mazurek.run.controller;

import mazurek.run.logic.InvoiceService;
import mazurek.run.model.Invoice;
import mazurek.run.model.InvoiceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

public class InvoiceController {

    InvoiceRepository repository;
    InvoiceService invoiceService;

    public InvoiceController(InvoiceRepository repository, InvoiceService invoiceService) {
        this.repository = repository;
        this.invoiceService = invoiceService;
    }


    @GetMapping(value="/invoices")
    ResponseEntity<List<Invoice>> readAllTasksKielbasa(){
        return ResponseEntity.ok( repository.findAll());
    }
    @PostMapping("/invoice")
    ResponseEntity<?> insertTask(@RequestBody @Valid Invoice toCreate){
        repository.save(toCreate);
        return ResponseEntity.ok( toCreate );
    }

    @GetMapping(value="/invoice/{id}")
    ResponseEntity readOneTaskKielbasa(@PathVariable int id){
        return ResponseEntity.ok(
                repository.findById( Integer.valueOf(id)).stream().findFirst()
        );
    }


}

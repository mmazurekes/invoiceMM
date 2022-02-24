package mazurek.run.model;

import java.time.LocalDateTime;

public class InvoiceWriteModel {
    private String invoiceNumber;
    private LocalDateTime purchaseDate;
    private String description;


    public Invoice toInvoice(){
        Invoice invoice = new Invoice(invoiceNumber,purchaseDate,description);
        return invoice;

    }
}

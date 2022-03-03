package mazurek.run.model;

import java.time.LocalDateTime;

public class InvoiceWriteModel {
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        //this.purchaseDate = purchaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String invoiceNumber;
    private LocalDateTime purchaseDate;
    private String description;


    public InvoiceWriteModel(String invoiceNumber, LocalDateTime purchaseDate, String description) {
        this.invoiceNumber = invoiceNumber;
        this.purchaseDate = purchaseDate;
        this.description = description;
    }

    public Invoice toInvoice(){
        Invoice invoice = new Invoice(invoiceNumber,purchaseDate,description);
        return invoice;
    }
}

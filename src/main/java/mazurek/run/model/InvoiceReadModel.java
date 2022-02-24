package mazurek.run.model;

import org.springframework.boot.SpringApplication;

import javax.swing.*;
import java.time.LocalDateTime;

public class InvoiceReadModel {
    private String description;
    private String  invoiceNumber;
    private LocalDateTime purchaseDate;
    private LocalDateTime createDate;

    public InvoiceReadModel(Invoice invoice) {

        this.invoiceNumber = invoice.getInvoiceNumber();
        this.purchaseDate = invoice.getPurchaseDate();
        this.createDate = invoice.getCreateDate();
        this.description = invoice.getDescription();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}

package mazurek.run.logic;

import mazurek.run.model.Invoice;
import mazurek.run.model.InvoiceReadModel;
import mazurek.run.model.InvoiceRepository;
import mazurek.run.model.InvoiceWriteModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {
    private InvoiceRepository repository;

    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }

    public InvoiceReadModel createInvoice(InvoiceWriteModel invoiceWriteModel){
        Invoice invoice = repository.save(invoiceWriteModel.toInvoice());
        return new InvoiceReadModel(invoice);
    }

    public List<InvoiceReadModel> readAll(){
        return repository.findAll()
                .stream()
                .map(InvoiceReadModel::new)
                .collect(Collectors.toList());
    }
}

package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product keyboard = new Product("keyboard");
        Product mouse = new Product("mouse");
        Product speakers = new Product("speakers");

        Item keyboardItem = new Item(keyboard, new BigDecimal(20), 10);
        Item mouseItem = new Item(mouse, new BigDecimal(15), 13);
        Item speakersItem = new Item(speakers, new BigDecimal(50), 8);

        List<Item> items = new ArrayList<>();
        items.add(keyboardItem);
        items.add(mouseItem);
        items.add(speakersItem);

        Invoice invoice = new Invoice("06/06/18",items);
        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();
        //Then
        Assert.assertNotEquals(0,id);
        //CleanUp
        invoiceDao.delete(id);
    }
}

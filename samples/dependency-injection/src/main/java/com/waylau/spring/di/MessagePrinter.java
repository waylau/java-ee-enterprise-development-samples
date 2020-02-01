/**
 * Welcome to https://waylau.com
 */
package com.waylau.spring.di;

import com.waylau.spring.di.service.MessageService;

/**
 * Message Printer.
 * 
 * @since 1.0.0 2020��2��1��
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class MessagePrinter {

    final private MessageService service;

    public MessagePrinter(MessageService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}
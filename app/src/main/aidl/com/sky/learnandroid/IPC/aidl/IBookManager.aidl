// IBookManager.aidl
package com.sky.learnandroid.IPC.aidl;

import com.sky.learnandroid.IPC.aidl.Book;

// Declare any non-default types here with import statements

interface IBookManager {

    List<Book> getBookList();
    void addBook(in Book book);
}

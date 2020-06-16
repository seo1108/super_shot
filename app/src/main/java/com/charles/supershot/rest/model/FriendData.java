package com.charles.supershot.rest.model;

import java.util.List;

public class FriendData {
    private List<FriendInfo> content;
    private Page pageble;
    private int totalPages;
    private boolean last;
    private int totalElements;
    private Sort sort;
    private int numberOfElements;
    private boolean first;
    private int size;
    private int number;
    private boolean empty;

    public List<FriendInfo> getContent() {
        return content;
    }

    public void setContent(List<FriendInfo> content) {
        this.content = content;
    }

    public Page getPageble() {
        return pageble;
    }

    public void setPageble(Page pageble) {
        this.pageble = pageble;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}

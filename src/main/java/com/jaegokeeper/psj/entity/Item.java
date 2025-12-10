package com.jaegokeeper.psj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;

    @ManyToOne(fetch = FetchType.EAGER)  // LAZY → EAGER
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "created_at")
    @JsonIgnore
    private LocalDateTime createdAt;

    @Column(name = "del_yn")
    private boolean delYn;

    public Item() {
    }

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isDelYn() {
        return delYn;
    }

    public void setDelYn(boolean delYn) {
        this.delYn = delYn;
    }
}
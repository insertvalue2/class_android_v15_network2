package com.nomadlab.myapplication.repository.models;

import com.google.gson.annotations.SerializedName;

public class Todo {
    @SerializedName("userId")
    public int userId;
    @SerializedName("id")
    public int id;
    @SerializedName("completed")
    public String completed;

    @Override
    public String toString() {
        return "Todo{" +
                "userId=" + userId +
                ", id=" + id +
                ", completed='" + completed + '\'' +
                '}';
    }
}

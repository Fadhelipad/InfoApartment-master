package com.example.infokavling.Model;

public class Category {

    private String  Nama;
    private String Image;
    private String Description;


    public Category() {

    }


    public Category(String nama, String image, String decription) {

        Nama = nama;
        Image = image;
        Description = decription;
    }

    public String getNama() {
        return Nama;

    }
    public void setNama (String nama) {

        Nama = nama;


    }
    public String getImage() {

        return Image;

    }

    public void setImage(String image)

    {
        Image = image;

    }


    public String getDescription() {

        return Description;

    }

    public void setDescription(String description)

    {
        Description = description;

    }



}


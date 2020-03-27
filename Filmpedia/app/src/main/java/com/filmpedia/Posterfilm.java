package com.filmpedia;

import android.os.Parcel;
import android.os.Parcelable;

public class Posterfilm implements Parcelable {
    private String judul, tanggal, deskripsi, rating, genre;
    private int foto;


    protected Posterfilm(Parcel in) {
        judul = in.readString();
        tanggal = in.readString();
        deskripsi = in.readString();
        rating = in.readString();
        foto = in.readInt();
        genre = in.readString();
    }

    public static final Creator<Posterfilm> CREATOR = new Creator<Posterfilm>() {
        @Override
        public Posterfilm createFromParcel(Parcel in) {
            return new Posterfilm(in);
        }

        @Override
        public Posterfilm[] newArray(int size) {
            return new Posterfilm[size];
        }
    };

    public Posterfilm() {

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(judul);
        dest.writeString(tanggal);
        dest.writeString(deskripsi);
        dest.writeString(rating);
        dest.writeInt(foto);
        dest.writeString(genre);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

}

package com.example.testogorach;
public class Pytanie {
    private String trescPytania;
    private int idObrazka;
    private boolean odpowiedz;
    private String podpowiedz;
    private boolean czyUdzielonaPoprawnaODpowiedz;

    public Pytanie(String trescPytania, int idObrazka, boolean odpowiedz, String podpowiedz) {
        this.trescPytania = trescPytania;
        this.idObrazka = idObrazka;
        this.odpowiedz = odpowiedz;
        this.podpowiedz = podpowiedz;
        czyUdzielonaPoprawnaODpowiedz =false;
    }

    public boolean isCzyUdzielonaPoprawnaODpowiedz() {
        return czyUdzielonaPoprawnaODpowiedz;
    }

    public void setCzyUdzielonaPoprawnaODpowiedz(boolean czyUdzielonaPoprawnaODpowiedz) {
        this.czyUdzielonaPoprawnaODpowiedz = czyUdzielonaPoprawnaODpowiedz;
    }

    public String getTrescPytania() {
        return trescPytania;
    }

    public void setTrescPytania(String trescPytania) {
        this.trescPytania = trescPytania;
    }

    public int getIdObrazka() {
        return idObrazka;
    }

    public void setIdObrazka(int idObrazka) {
        this.idObrazka = idObrazka;
    }

    public boolean isOdpowiedz() {
        return odpowiedz;
    }

    public void setOdpowiedz(boolean odpowiedz) {
        this.odpowiedz = odpowiedz;
    }

    public String getPodpowiedz() {
        return podpowiedz;
    }

    public void setPodpowiedz(String podpowiedz) {
        this.podpowiedz = podpowiedz;
    }
}

package com.mnaufal.hibernateone2one.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Mahasiswa implements Serializable {

    @Id
    private String nim;
    private String nama;
    private float ipk;
    private String jurusan;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "alamat_id")
    private Alamat alamat;

    public Mahasiswa() {
    }

    public Mahasiswa(String nim, String nama, float ipk, String jurusan, Alamat alamat) {
        this.nim = nim;
        this.nama = nama;
        this.ipk = ipk;
        this.jurusan = jurusan;
        this.alamat = alamat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mahasiswa mahasiswa = (Mahasiswa) o;
        return Float.compare(mahasiswa.ipk, ipk) == 0 &&
                nim.equals(mahasiswa.nim) &&
                nama.equals(mahasiswa.nama) &&
                jurusan.equals(mahasiswa.jurusan) &&
                alamat.equals(mahasiswa.alamat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nim, nama, ipk, jurusan, alamat);
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public float getIpk() {
        return ipk;
    }

    public void setIpk(float ipk) {
        this.ipk = ipk;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public Alamat getAlamat() {
        return alamat;
    }

    public void setAlamat(Alamat alamat) {
        this.alamat = alamat;
    }
}

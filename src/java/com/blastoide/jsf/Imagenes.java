/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jsf;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "Imagenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagenes.findAll", query = "SELECT i FROM Imagenes i")
    , @NamedQuery(name = "Imagenes.findByImagenID", query = "SELECT i FROM Imagenes i WHERE i.imagenID = :imagenID")
    , @NamedQuery(name = "Imagenes.findByFileName", query = "SELECT i FROM Imagenes i WHERE i.fileName = :fileName")
    , @NamedQuery(name = "Imagenes.findByContentType", query = "SELECT i FROM Imagenes i WHERE i.contentType = :contentType")
    , @NamedQuery(name = "Imagenes.findByFileType", query = "SELECT i FROM Imagenes i WHERE i.fileType = :fileType")})
public class Imagenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "imagenID")
    private Integer imagenID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "file_name")
    private String fileName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contentType")
    private int contentType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fileType")
    private int fileType;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "file_Imagen")
    private byte[] fileImagen;
    @JoinColumn(name = "productoID", referencedColumnName = "productoID")
    @ManyToOne(optional = false)
    private Productos productoID;

    public Imagenes() {
    }

    public Imagenes(Integer imagenID) {
        this.imagenID = imagenID;
    }

    public Imagenes(Integer imagenID, String fileName, int contentType, int fileType, byte[] fileImagen) {
        this.imagenID = imagenID;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileType = fileType;
        this.fileImagen = fileImagen;
    }

    public Integer getImagenID() {
        return imagenID;
    }

    public void setImagenID(Integer imagenID) {
        this.imagenID = imagenID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public byte[] getFileImagen() {
        return fileImagen;
    }

    public void setFileImagen(byte[] fileImagen) {
        this.fileImagen = fileImagen;
    }

    public Productos getProductoID() {
        return productoID;
    }

    public void setProductoID(Productos productoID) {
        this.productoID = productoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imagenID != null ? imagenID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagenes)) {
            return false;
        }
        Imagenes other = (Imagenes) object;
        if ((this.imagenID == null && other.imagenID != null) || (this.imagenID != null && !this.imagenID.equals(other.imagenID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.blastoide.jsf.Imagenes[ imagenID=" + imagenID + " ]";
    }
    
}

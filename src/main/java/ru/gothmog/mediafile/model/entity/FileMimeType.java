package ru.gothmog.mediafile.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "mime_type")
public class FileMimeType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "mime_type_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "file_content_id")
    private FileContent file;

    @Column(name="mime_type")
    @Enumerated(EnumType.STRING)
    private MimeType mimeType;

    public FileMimeType() {
    }

    public FileMimeType(MimeType mimeType) {
        this.mimeType = mimeType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FileContent getFile() {
        return file;
    }

    public void setFile(FileContent file) {
        this.file = file;
    }

    public MimeType getMimeType() {
        return mimeType;
    }

    public void setMimeType(MimeType mimeType) {
        this.mimeType = mimeType;
    }
}

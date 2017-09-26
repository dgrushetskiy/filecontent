package ru.gothmog.mediafile.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "file_content")
public class FileContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_content_id")
    private Long id;

    @Lob
    @Column(name = "content_file", nullable = false)
    private byte[] contentFile;

    @OneToMany(mappedBy = "file", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<FileMimeType> mimeTypes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getContentFile() {
        return contentFile;
    }

    public void setContentFile(byte[] contentFile) {
        this.contentFile = contentFile;
    }

    public List<FileMimeType> getMimeTypes() {
        if (mimeTypes == null)
            mimeTypes = new ArrayList<>();
        return mimeTypes;
    }

    public void setMimeTypes(List<FileMimeType> mimeTypes) {
        this.mimeTypes = mimeTypes;
    }

    public void removeMimeType(MimeType mimeType){
        if (getMimeTypes() != null && !getMimeTypes().isEmpty() && mimeTypes != null)
            getMimeTypes().remove(mimeType);
    }
}

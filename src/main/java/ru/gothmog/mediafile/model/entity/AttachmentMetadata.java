package ru.gothmog.mediafile.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "attachment_metadata", indexes = @Index(name = "fki_file_object_content", columnList = "file_content_id", unique = true))
public class AttachmentMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "metadata_id")
    private Long id;

    @Column(name="widget")
    private String widget = "";

    @Column(name="file_name")
    private String fileName = "attachment";

    @Column(name="title")
    private String title = "(untitled)";

    @Column(name="description")
    private String description = "";

    @Column(name="creation_date")
    private Date creationDate = new Date();

    @Column(name = "file_size")
    private Integer size;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "file_content_id")
    private FileContent file;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWidget() {
        return widget;
    }

    public void setWidget(String widget) {
        this.widget = widget;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public FileContent getFileContent() {
        if (file == null){
            file = new FileContent();
        }
        return file;
    }

    public void setFileContent(FileContent file) {
        this.file = file;
    }

    @Transient
    public String getTypes(){
        String types = "";
        if (getFileContent() != null){
            if (getFileContent().getMimeTypes() != null){
                for (FileMimeType mimeType : getFileContent().getMimeTypes()){
                    if (!types.equals(""))
                        types += ", ";
                    types += mimeType.getMimeType().toString();
                }
            }
        }
        return types;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object object){
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (!(object instanceof AttachmentMetadata))
            return false;
        AttachmentMetadata other = (AttachmentMetadata) object;
        if (id == null){
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}

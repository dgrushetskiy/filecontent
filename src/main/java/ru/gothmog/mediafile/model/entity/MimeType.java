package ru.gothmog.mediafile.model.entity;

public enum MimeType {

    DEFAULT_MIME_TYPE("application/octet-stream"),
    PDF_MIME_TYPE("application/pdf"),
    DOC_MIME_TYPE("application/msword"),
    DOT_MIME_TYPE("application/msword"),
    DWG_MIME_TYPE("application/acad"),
    DWG_IMAGE_MIME_TYPE("image/vnd.dwg"),
    GIF_IMAGE_MIME_TYPE("image/gif"),
    JPEG_IMAGE_MIME_TYPE("image/jpeg"),
    JPG_IMAGE_MIME_TYPE("image/jpeg"),
    PNG_IMAGE_MIME_TYPE("image/png");

    private String fileMimeType;

    MimeType(String fileMimeType) {
        this.fileMimeType = fileMimeType;
    }

    public String getFileMimeType() {
        return fileMimeType;
    }

    @Override
    public String toString() {
        return "MimeType{" +
                "fileMimeType='" + fileMimeType + '\'' +
                '}';
    }
}

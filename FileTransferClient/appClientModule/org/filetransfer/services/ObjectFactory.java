
package org.filetransfer.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.filetransfer.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UploadPDF_QNAME = new QName("http://services.filetransfer.org/", "uploadPDF");
    private final static QName _UploadPDFResponse_QNAME = new QName("http://services.filetransfer.org/", "uploadPDFResponse");
    private final static QName _DownloadPDFResponse_QNAME = new QName("http://services.filetransfer.org/", "downloadPDFResponse");
    private final static QName _DownloadPDF_QNAME = new QName("http://services.filetransfer.org/", "downloadPDF");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.filetransfer.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DownloadPDFResponse }
     * 
     */
    public DownloadPDFResponse createDownloadPDFResponse() {
        return new DownloadPDFResponse();
    }

    /**
     * Create an instance of {@link DownloadPDF }
     * 
     */
    public DownloadPDF createDownloadPDF() {
        return new DownloadPDF();
    }

    /**
     * Create an instance of {@link UploadPDFResponse }
     * 
     */
    public UploadPDFResponse createUploadPDFResponse() {
        return new UploadPDFResponse();
    }

    /**
     * Create an instance of {@link UploadPDF }
     * 
     */
    public UploadPDF createUploadPDF() {
        return new UploadPDF();
    }

    /**
     * Create an instance of {@link FileData }
     * 
     */
    public FileData createFileData() {
        return new FileData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadPDF }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.filetransfer.org/", name = "uploadPDF")
    public JAXBElement<UploadPDF> createUploadPDF(UploadPDF value) {
        return new JAXBElement<UploadPDF>(_UploadPDF_QNAME, UploadPDF.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadPDFResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.filetransfer.org/", name = "uploadPDFResponse")
    public JAXBElement<UploadPDFResponse> createUploadPDFResponse(UploadPDFResponse value) {
        return new JAXBElement<UploadPDFResponse>(_UploadPDFResponse_QNAME, UploadPDFResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadPDFResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.filetransfer.org/", name = "downloadPDFResponse")
    public JAXBElement<DownloadPDFResponse> createDownloadPDFResponse(DownloadPDFResponse value) {
        return new JAXBElement<DownloadPDFResponse>(_DownloadPDFResponse_QNAME, DownloadPDFResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadPDF }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.filetransfer.org/", name = "downloadPDF")
    public JAXBElement<DownloadPDF> createDownloadPDF(DownloadPDF value) {
        return new JAXBElement<DownloadPDF>(_DownloadPDF_QNAME, DownloadPDF.class, null, value);
    }

}

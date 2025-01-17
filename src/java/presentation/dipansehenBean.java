/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.apache.pdfbox.pdmodel.PDDocument;
import pojo.Autor;
import pojo.Diplomarbeit;
import service.DatabaseManagerService;

/**
 *
 * @author hp
 */
public class dipansehenBean implements Serializable  {

    private Diplomarbeit aktDip;

    //Variablen
    private String titel;
    private String autor;
    private String schule;
    private Date date;
    private int seitenanzahl = 0;
    private int aktuelle_id;
    private String buttonId;
    private String result;
    private String imagepath;

    private String bildnamegleich;
    private String pdfnamegleich;

    private DatabaseManagerService dbService;

    //Click/Downlaod-Counter
    private int download_count;
    private int click_count;
    private String DateBefore;
    private String TimeBefore;
    private boolean resetcounter;
    private String server_diplomarbeit_pfad;
    private String server_image_pfad;
    private String server_text_pfad;

    private String autorListe;
    private List<Autor> varList;
    private int numberofpages;
    private java.util.Date utilDate;
    private String dateFormat;

    public dipansehenBean() {

    }

    @PostConstruct
    void init() {
        varList = new ArrayList<>();

    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String Titel) {
        this.titel = Titel;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSchule() {
        return schule;
    }

    public void setSchule(String schule) {
        this.schule = schule;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getSeitenanzahl() {
        return seitenanzahl;
    }

    public void setSeitenanzahl(int seitenanzahl) {
        this.seitenanzahl = seitenanzahl;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public int getAktuelle_id() {
        return aktuelle_id;
    }

    public void setAktuelle_id(int aktuelle_id) {
        this.aktuelle_id = aktuelle_id;
    }

    public String getBildnamegleich() {
        return bildnamegleich;
    }

    public void setBildnamegleich(String bildnamegleich) {
        this.bildnamegleich = bildnamegleich;
    }

    public String getPdfnamegleich() {
        return pdfnamegleich;
    }

    public void setPdfnamegleich(String pdfnamegleich) {
        this.pdfnamegleich = pdfnamegleich;
    }

    public Diplomarbeit getAktDip() {
        return aktDip;
    }

    public void setAktDip(Diplomarbeit aktDip) {
        this.aktDip = aktDip;
    }

    public DatabaseManagerService getDbService() {
        return dbService;
    }

    public void setDbService(DatabaseManagerService dbService) {
        this.dbService = dbService;
    }

    //------------------Click/Download Counter --------------------------
    public int getClick_count() {
        return click_count;
    }

    public void setClick_count(int click_count) {
        this.click_count = click_count;
    }

    public int getDownload_count() {
        return download_count;
    }

    public void setDownload_count(int download_count) {
        this.download_count = download_count;
    }

    public String getDateBefore() {
        return DateBefore;
    }

    public void setDateBefore(String DateBefore) {
        this.DateBefore = DateBefore;
    }

    public String getTimeBefore() {
        return TimeBefore;
    }

    public void setTimeBefore(String TimeBefore) {
        this.TimeBefore = TimeBefore;
    }

    public boolean isResetcounter() {
        return resetcounter;
    }

    public void setResetcounter(boolean resetcounter) {
        this.resetcounter = resetcounter;
    }

    private int zähler = 0;

    public int getZähler() {
        return zähler;
    }

    public void setZähler(int zähler) {
        this.zähler = zähler;
    }

    public String getServer_diplomarbeit_pfad() {
        return server_diplomarbeit_pfad;
    }

    public void setServer_diplomarbeit_pfad(String server_diplomarbeit_pfad) {
        this.server_diplomarbeit_pfad = server_diplomarbeit_pfad;
    }

    public String getServer_image_pfad() {
        return server_image_pfad;
    }

    public void setServer_image_pfad(String server_image_pfad) {
        this.server_image_pfad = server_image_pfad;
    }

    public String getAutorListe() {
        autorListe = this.showAllAutor();
        return autorListe;
    }

    public void setAutorListe(String autorListe) {
        this.autorListe = autorListe;
    }

    public List<Autor> getVarList() {
        return varList;
    }

    public void setVarList(List<Autor> varList) {
        this.varList = varList;
    }

    public String getServer_text_pfad() {
        return server_text_pfad;
    }

    public void setServer_text_pfad(String server_text_pfad) {
        this.server_text_pfad = server_text_pfad;
    }

    public int getNumberofpages() {
        return numberofpages;
    }

    public void setNumberofpages(int numberofpages) {
        this.numberofpages = numberofpages;
    }

    public java.util.Date getUtilDate() {
        return utilDate;
    }

    public void setUtilDate(java.util.Date utilDate) {
        this.utilDate = utilDate;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
    
    

    
    
    
    
    
    

    //--------------------Werteanzeigen-----------------------------------------
    public String werteanzeigen(Diplomarbeit dip) {
        this.manipulationText(dip);
        this.getNumberofpages();
        this.aktDip = dip;
        this.autor = dbService.getOneAutor(dip.getDa_id()).getFullName();
        this.dateFormat = this.convertSQLDateToUtilDate(dip.getDatum());

        FacesContext fc = (FacesContext) FacesContext.getCurrentInstance();
        ServletContext sc = (ServletContext) fc.getExternalContext().getContext();

        this.server_diplomarbeit_pfad = sc.getRealPath("").replaceAll("\\\\", "/").replaceAll("/build", "") + "/resources/pdf/" + aktDip.getTitle() + ".pdf";
        this.server_image_pfad = sc.getRealPath("").replaceAll("\\\\", "/").replaceAll("/build", "") + this.aktDip.getBild();
        this.server_text_pfad = sc.getRealPath("").replaceAll("\\\\", "/").replaceAll("/build", "") + this.aktDip.getTextname();

        this.schule = dbService.getOneSchule(aktDip.getSchule_id()).getName();
        dbService.getAktuellPicture(this.aktDip);
        this.click_count_diplomarbeit(this.aktDip);

        return "dipansehen.xhtml";
    }

//------------------------------------------------------------------------------   
    public String show(Diplomarbeit dip) {

        dbService.ListeAllDiplomarbeiten();

        //Schule anzeigen funktioniert noch nicht!!!
        //NullpointExcepiton
        this.schule = dbService.getOneSchule(aktDip.getSchule_id()).getName();
        dbService.getAktuellPicture(this.aktDip);
        this.click_count_diplomarbeit(this.aktDip);

        return "dipansehen.xhtml";
    }

    public String NowDayBefore() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.now();
        return this.DateBefore = date.format(formatter);
    }

    public String NowYearLocalBefore() {
        LocalDate Nowdate = LocalDate.now();
        String nextyear = String.valueOf(Nowdate.getYear() + 1);
        return nextyear;
    }

    //2. Variable Date 
    public String NowTimeBefore() {
        LocalTime startTime = LocalTime.now();
        System.out.println(startTime);
        return this.TimeBefore = startTime.toString();
    }

    public LocalTime NowTimeLocalBefore() {
        LocalTime startTime = LocalTime.now();
        return startTime;
    }

    public String DateBeforFormat() {

        String vResetdate = "01-01-";
        String vyear = this.NowYearLocalBefore();
        return (vResetdate + vyear);

    }

    public boolean ResetCounter() {
        return this.resetcounter = this.NowDayBefore().equals(this.DateBeforFormat());
    }

    //------------------------Click-Count----------------------------
    public void click_count_diplomarbeit(Diplomarbeit dip) {

        double click_first_grenze = 10E+6;
        double click_second_grenze = 10E+12;

        this.click_count = this.readClickCount(dip);

        if (!this.ResetCounter()) {

            if (this.click_count < click_first_grenze) {

                System.out.println("< als 1 Millionen mal geklickt!!!" + this.click_count);
                this.click_count += 1;
                System.out.println("Danach" + this.click_count);
                dbService.click_count(this.click_count, dip);

            } else if (this.click_count > click_first_grenze) {

                this.click_count += 1;
                System.out.println("> als 1 Millionen mal geklickt!!!");
                dbService.click_count(this.click_count, dip);

            } else if (click_second_grenze <= click_second_grenze) {

                this.click_count += 1;
                System.out.println("< 1 Milliarde mal geklickt!!!");
                dbService.click_count(this.click_count, dip);

            } else if (click_second_grenze > click_second_grenze) {

                this.click_count += 1;
                System.out.println("Mehr als 1 Milliarde mal geklickt!!!");
                dbService.click_count(this.click_count, dip);
            }

        } else {
            click_count = 0;
            dbService.click_count(click_count, dip);
        }

    }

    //-----------------Download-Count-Diplomarbeit-------------------------
    public void download_count() {

        double downlaod_first_grenze = 10E+6;
        double download_second_grenze = 10E+12;
        this.download_count = this.readDownloadCount(this.aktDip);

        if (!this.ResetCounter()) {

            if (this.download_count < downlaod_first_grenze) {

                System.out.println("< als 1 Millionen mal geklickt!!!");
                download_count += 1;
                System.out.println("Download count:" + download_count);
                dbService.downloadt_count(download_count, this.aktDip);

            } else if (download_count > downlaod_first_grenze) {

                download_count += 1;
                System.out.println("> als 1 Millionen mal geklickt!!!");
                System.out.println(download_count);
                dbService.downloadt_count(download_count, this.aktDip);

            } else if (download_count <= download_second_grenze) {

                download_count += 1;
                System.out.println("< 1 Milliarde mal geklickt!!!");
                System.out.println(download_count);
                dbService.downloadt_count(download_count, this.aktDip);

            } else if (download_count > download_second_grenze) {

                download_count += 1;
                System.out.println("Mehr als 1 Milliarde mal geklickt!!!");
                System.out.println("Download count:" + download_count);
                dbService.downloadt_count(download_count, this.aktDip);
            }

        } else {
            download_count = 0;
            System.out.println(download_count);
            dbService.downloadt_count(download_count, this.aktDip);
        }

    }

    public int readClickCount(Diplomarbeit dip) {
        return dbService.read_clickcount(dip);
    }

    public int readDownloadCount(Diplomarbeit dip) {
        return dbService.read_downloadcount(dip);
    }

    //---------------------Diplomarbeit download---------------------------------
    public Object download() throws IOException {

        FacesContext fc = (FacesContext) FacesContext.getCurrentInstance();
        ServletContext sc = (ServletContext) fc.getExternalContext().getContext();
        ExternalContext externalContext = fc.getExternalContext();

        externalContext.responseReset();
        externalContext.setResponseContentType(aktDip.getTitle() + "/.pdf");
        externalContext.setResponseHeader("Content-Disposition", "attachment;filename=\"" + aktDip.getTitle());

        externalContext.setResponseHeader("Content-Disposition", "attachment;filename=\"" + aktDip.getTitle() + ".pdf" + "\"");
        this.server_diplomarbeit_pfad = sc.getRealPath("").replaceAll("\\\\", "/").replaceAll("/build", "") + "/resources/pdf/";
        File file = new File(server_diplomarbeit_pfad + aktDip.getTitle() + ".pdf");

        OutputStream outputStream;
        try (FileInputStream inputStream = new FileInputStream(file)) {
            outputStream = externalContext.getResponseOutputStream();
            byte[] buffer = new byte[5000];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        }

        fc.responseComplete();
        this.download_count();

        return null;

    }

    public String imagepath_auslesen(int id) {
        Diplomarbeit dip = dbService.getDiplomarbeit(id);
        String var_imagepath = dip.getBild();
        return var_imagepath;
    }

    public String bildanzeigen() {
        return this.imagepath;
    }
//------------------------------------------------------------------------------  

    //----------------------------Favouriten------------------------------------
    public void favspeichern() {

        int b_id = dbService.getLoggedInBenutzer().getUser_id();
        System.out.println("-------------------- benutzerid" + b_id);
        System.out.println("-------------------- dipid" + aktDip.getDa_id());

        int res = dbService.insertFavouriten(aktDip.getDa_id(), b_id);
        if (res == 1) {
            titel = "Success";
        };
    }

    public void löschenDiplomarbeit(ActionEvent event) {

        int res = dbService.deleteDiplomarbeit(aktDip);
        if (res == 1) {
            titel = "Success";
            this.deletePDFFile(this.server_diplomarbeit_pfad);
            this.deleteImage(this.server_image_pfad);
            this.deleteTextFile(this.server_text_pfad);
        };

    }
    
    
    public boolean deletePDFFile(String filepath) {
        boolean del = false;
        File file = new File(filepath);

        if (file.exists() && file.exists()) {
            del = file.delete();
            file.delete();
            System.out.println("Datei wurde gelöscht!!!");
        }
        return del;
    }

    public boolean deleteImage(String filepath) {
        boolean del = false;
        File file = new File(filepath);

        if (file.exists() && file.exists()) {
            del = file.delete();
            file.delete();
            System.out.println("Datei wurde gelöscht!!!");
        }
        return del;
    }

    public boolean deleteTextFile(String filepath) {
        boolean del = false;
        File file = new File(filepath);

        if (file.exists() && file.exists()) {
            del = file.delete();
            file.delete();
            System.out.println("Datei wurde gelöscht!!!");
        }
        return del;
    }



//------------------------------------------------------------------------------    
    private String ladeDatei(Diplomarbeit dip) {
        FileReader fr = null;
        int c;
        FacesContext fc = (FacesContext) FacesContext.getCurrentInstance();
        ServletContext sc = (ServletContext) fc.getExternalContext().getContext();
        this.server_text_pfad = sc.getRealPath("").replaceAll("\\\\", "/").replaceAll("/build", "") + dip.getTextname();

        System.out.println("--------------------" + this.server_text_pfad);

//        File file = new File(this.server_text_pfad);
        File file = new File(this.server_text_pfad);

        if (file.exists()) {
            StringBuilder buff = new StringBuilder();
            try {
                fr = new FileReader(file);
                while ((c = fr.read()) != -1) {
                    buff.append((char) c);
                }
                fr.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return buff.toString();
        } else {
            return "";
        }

    }

    private String text1;
    private String text2;
    private String fullText;

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }
    
    

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String manipulationText(Diplomarbeit dip) {

        fullText = this.ladeDatei(dip);

        if (!(fullText == null)) {

            if (this.fullText.length() != 0) {
                return fullText;
            } else {
                return fullText = "Keine Einleitung vorhanden!";
            }

//            this.text1 = fullText.substring(0, (fullText.length() / 2));
//            this.text2 = fullText.substring((fullText.length() / 2), fullText.length());
        } else {

            return this.fullText = "";

        }

     
    }
    
    


    public String showAllAutor() {

        varList = dbService.getAllAutor(this.getAktDip().getDa_id());
        
        String autorListefirst = "";
        String autorListesecond = "";
        String fullautorListe = "";

        for (int i = 0; i < varList.size(); i++) {

            if (i == 0) {
                autorListefirst = "" + varList.get(i).getFullName();
            } else {
                autorListesecond += " , " + varList.get(i).getFullName();
            }

            fullautorListe = autorListefirst + autorListesecond;

        }
        
        return fullautorListe;
    }
    
    
    
    
    public int getNumberOfPages(Diplomarbeit dip) throws IOException {
        
        FacesContext fc = (FacesContext) FacesContext.getCurrentInstance();
        ServletContext sc = (ServletContext) fc.getExternalContext().getContext();
        this.server_text_pfad = sc.getRealPath("").replaceAll("\\\\", "/").replaceAll("/build", "") + dip.getPdf();
        System.out.println("PDf pfad ---------------" + this.server_text_pfad);

        File pdf = new File(this.server_text_pfad);

        if (pdf.exists()) {

            //Instantiating the PDFRenderer class
            try (PDDocument document = PDDocument.load(pdf)) {
                System.out.println(document);
                
                this.numberofpages = document.getNumberOfPages();
                
                
            }

        } else {
            System.out.println("PDf ist nicht vorhanden!");
        }
        
        return this.numberofpages;

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //----------------Alter Code - Diplomarbeit ansehen-----------------------------
    public void diplomarbeitansehen(Diplomarbeit dip) {

        FacesContext fc = (FacesContext) FacesContext.getCurrentInstance();
        ServletContext sc = (ServletContext) fc.getExternalContext().getContext();
        String s_diplomarbeit_pfad = sc.getRealPath("").replaceAll("\\\\", "/").replaceAll("/build", "") + "/resources/pdf/";

        try {

            //Pfad anpassen
            File pdfFile = new File(s_diplomarbeit_pfad + aktDip.getTitle() + ".pdf");

            if (pdfFile.exists()) {

                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Desktop is not supported!");

                }

            } else {
                System.out.println("File is not exists!");
            }

            System.out.println("Done");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    
    
    public String convertSQLDateToUtilDate(java.sql.Date date) {
        
        utilDate = new java.util.Date(date.getTime());
        
        String pattern = "dd.MM.yyyy";
        SimpleDateFormat  simpledateformat = new SimpleDateFormat(pattern);
        dateFormat = simpledateformat.format(utilDate);
        
        
        return dateFormat; 
        
        
        
    }
    
    
    

}

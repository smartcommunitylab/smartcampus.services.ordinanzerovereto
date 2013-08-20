package eu.trentorise.smartcampus.services.ordinanzerovereto.data.message;

import java.util.List;
import java.util.LinkedList;

import it.sayservice.xss.api.XSSDataException;
import it.sayservice.xss.api.data.XSSData;
import it.sayservice.xss.api.data.DOMData;

import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;

import it.sayservice.platform.core.message.ProtoBean;
/**
*
* Generated ProtoBean class: DO NOT EDIT!
*
*/
public class OrdinanzeroveretoProtoBean {
   public static class OrdinanzaProtoBean implements ProtoBean {
          private String id;
    public String getId() {
      return id;
    }
    public void setId(String id) {
      this.id = id;
    }
    
          private String ogetto;
    public String getOgetto() {
      return ogetto;
    }
    public void setOgetto(String ogetto) {
      this.ogetto = ogetto;
    }
    
          private String data;
    public String getData() {
      return data;
    }
    public void setData(String data) {
      this.data = data;
    }
    
          private String dal;
    public String getDal() {
      return dal;
    }
    public void setDal(String dal) {
      this.dal = dal;
    }
    
          private String al;
    public String getAl() {
      return al;
    }
    public void setAl(String al) {
      this.al = al;
    }
    
          private String tipologia;
    public String getTipologia() {
      return tipologia;
    }
    public void setTipologia(String tipologia) {
      this.tipologia = tipologia;
    }
    
          private String stato;
    public String getStato() {
      return stato;
    }
    public void setStato(String stato) {
      this.stato = stato;
    }
    
          private List<eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.OrdinanzeroveretoProtoBean.ViaProtoBean> vieList;
    public List<eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.OrdinanzeroveretoProtoBean.ViaProtoBean> getVieList() {
      return vieList;
    }
    public void setVieList(List<eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.OrdinanzeroveretoProtoBean.ViaProtoBean> vieList) {
      this.vieList = vieList;
    }
    public eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.OrdinanzeroveretoProtoBean.ViaProtoBean getVie(int i) {
      return vieList .get(i);
    }
    public int getVieCount() {
      return vieList .size();
    }
    
    
    public OrdinanzaProtoBean() {
    	super();
    }
    
    public OrdinanzaProtoBean(eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.Ordinanzerovereto.Ordinanza reference) {
      super();
                        setId(reference.getId());
                                    setOgetto(reference.getOgetto());
                                    setData(reference.getData());
                                    setDal(reference.getDal());
                                    setAl(reference.getAl());
                                    setTipologia(reference.getTipologia());
                                    setStato(reference.getStato());
                                    if (reference.getVieList()!=null) {
        vieList = new LinkedList<eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.OrdinanzeroveretoProtoBean.ViaProtoBean>();
        for (eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.Ordinanzerovereto.Via item : reference.getVieList()) {
          getVieList().add(new eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.OrdinanzeroveretoProtoBean.ViaProtoBean(item));
        }
      }
                      }  

    public OrdinanzaProtoBean(XSSData data) throws XSSDataException {
      super();
                        if (data.get("id") != null && !data.get("id").isEmpty()) {
            if (data.get("id").size()>1) throw new XSSDataException("Incorrect data cardinality for field id: expected single value.");
            
            Object item = data.get("id").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field id: expected DOMData");
                                  setId(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("ogetto") != null && !data.get("ogetto").isEmpty()) {
            if (data.get("ogetto").size()>1) throw new XSSDataException("Incorrect data cardinality for field ogetto: expected single value.");
            
            Object item = data.get("ogetto").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field ogetto: expected DOMData");
                                  setOgetto(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("data") != null && !data.get("data").isEmpty()) {
            if (data.get("data").size()>1) throw new XSSDataException("Incorrect data cardinality for field data: expected single value.");
            
            Object item = data.get("data").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field data: expected DOMData");
                                  setData(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("dal") != null && !data.get("dal").isEmpty()) {
            if (data.get("dal").size()>1) throw new XSSDataException("Incorrect data cardinality for field dal: expected single value.");
            
            Object item = data.get("dal").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field dal: expected DOMData");
                                  setDal(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("al") != null && !data.get("al").isEmpty()) {
            if (data.get("al").size()>1) throw new XSSDataException("Incorrect data cardinality for field al: expected single value.");
            
            Object item = data.get("al").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field al: expected DOMData");
                                  setAl(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("tipologia") != null && !data.get("tipologia").isEmpty()) {
            if (data.get("tipologia").size()>1) throw new XSSDataException("Incorrect data cardinality for field tipologia: expected single value.");
            
            Object item = data.get("tipologia").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field tipologia: expected DOMData");
                                  setTipologia(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("stato") != null && !data.get("stato").isEmpty()) {
            if (data.get("stato").size()>1) throw new XSSDataException("Incorrect data cardinality for field stato: expected single value.");
            
            Object item = data.get("stato").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field stato: expected DOMData");
                                  setStato(convertToString(((DOMData)item).getStringValue()));
                                      }
                                vieList = new LinkedList<eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.OrdinanzeroveretoProtoBean.ViaProtoBean>();
          if (data.get("vie")!=null) {
            for (Object item : data.get("vie")) {
                              if (!(item instanceof XSSData)) throw new XSSDataException("Incorrect data type for field vie: expected XSSData");
                getVieList().add(new eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.OrdinanzeroveretoProtoBean.ViaProtoBean((XSSData)item));
                          }
          }
                  }  

    
    public eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.Ordinanzerovereto.Ordinanza buildMessage() {
      eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.Ordinanzerovereto.Ordinanza .Builder builder = eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.Ordinanzerovereto.Ordinanza .newBuilder();
                        if (getId() != null) {
      	builder.setId(getId());
      }
                                    if (getOgetto() != null) {
      	builder.setOgetto(getOgetto());
      }
                                    if (getData() != null) {
      	builder.setData(getData());
      }
                                    if (getDal() != null) {
      	builder.setDal(getDal());
      }
                                    if (getAl() != null) {
      	builder.setAl(getAl());
      }
                                    if (getTipologia() != null) {
      	builder.setTipologia(getTipologia());
      }
                                    if (getStato() != null) {
      	builder.setStato(getStato());
      }
                              if (getVieList()!=null) {
        for (eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.OrdinanzeroveretoProtoBean.ViaProtoBean item : getVieList()) {
                    builder. addVie(item.buildMessage());
                  }
      }
                  return builder.buildPartial();
    }
    
    
  }
  public static class ViaProtoBean implements ProtoBean {
          private String codiceVia;
    public String getCodiceVia() {
      return codiceVia;
    }
    public void setCodiceVia(String codiceVia) {
      this.codiceVia = codiceVia;
    }
    
          private String descrizioneVia;
    public String getDescrizioneVia() {
      return descrizioneVia;
    }
    public void setDescrizioneVia(String descrizioneVia) {
      this.descrizioneVia = descrizioneVia;
    }
    
          private String note;
    public String getNote() {
      return note;
    }
    public void setNote(String note) {
      this.note = note;
    }
    
          private Double lat;
    public Double getLat() {
      return lat;
    }
    public void setLat(Double lat) {
      this.lat = lat;
    }
    
          private Double lng;
    public Double getLng() {
      return lng;
    }
    public void setLng(Double lng) {
      this.lng = lng;
    }
    
          private String dalCivico;
    public String getDalCivico() {
      return dalCivico;
    }
    public void setDalCivico(String dalCivico) {
      this.dalCivico = dalCivico;
    }
    
          private String alCivico;
    public String getAlCivico() {
      return alCivico;
    }
    public void setAlCivico(String alCivico) {
      this.alCivico = alCivico;
    }
    
          private String dalIntersezione;
    public String getDalIntersezione() {
      return dalIntersezione;
    }
    public void setDalIntersezione(String dalIntersezione) {
      this.dalIntersezione = dalIntersezione;
    }
    
          private String alIntersezione;
    public String getAlIntersezione() {
      return alIntersezione;
    }
    public void setAlIntersezione(String alIntersezione) {
      this.alIntersezione = alIntersezione;
    }
    
          private String tipologia;
    public String getTipologia() {
      return tipologia;
    }
    public void setTipologia(String tipologia) {
      this.tipologia = tipologia;
    }
    
    
    public ViaProtoBean() {
    	super();
    }
    
    public ViaProtoBean(eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.Ordinanzerovereto.Via reference) {
      super();
                        setCodiceVia(reference.getCodiceVia());
                                    setDescrizioneVia(reference.getDescrizioneVia());
                                    setNote(reference.getNote());
                                    setLat(reference.getLat());
                                    setLng(reference.getLng());
                                    setDalCivico(reference.getDalCivico());
                                    setAlCivico(reference.getAlCivico());
                                    setDalIntersezione(reference.getDalIntersezione());
                                    setAlIntersezione(reference.getAlIntersezione());
                                    setTipologia(reference.getTipologia());
                      }  

    public ViaProtoBean(XSSData data) throws XSSDataException {
      super();
                        if (data.get("codice_via") != null && !data.get("codice_via").isEmpty()) {
            if (data.get("codice_via").size()>1) throw new XSSDataException("Incorrect data cardinality for field codiceVia: expected single value.");
            
            Object item = data.get("codice_via").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field codiceVia: expected DOMData");
                                  setCodiceVia(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("descrizione_via") != null && !data.get("descrizione_via").isEmpty()) {
            if (data.get("descrizione_via").size()>1) throw new XSSDataException("Incorrect data cardinality for field descrizioneVia: expected single value.");
            
            Object item = data.get("descrizione_via").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field descrizioneVia: expected DOMData");
                                  setDescrizioneVia(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("note") != null && !data.get("note").isEmpty()) {
            if (data.get("note").size()>1) throw new XSSDataException("Incorrect data cardinality for field note: expected single value.");
            
            Object item = data.get("note").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field note: expected DOMData");
                                  setNote(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("lat") != null && !data.get("lat").isEmpty()) {
            if (data.get("lat").size()>1) throw new XSSDataException("Incorrect data cardinality for field lat: expected single value.");
            
            Object item = data.get("lat").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field lat: expected DOMData");
                                  setLat(convertToDouble(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("lng") != null && !data.get("lng").isEmpty()) {
            if (data.get("lng").size()>1) throw new XSSDataException("Incorrect data cardinality for field lng: expected single value.");
            
            Object item = data.get("lng").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field lng: expected DOMData");
                                  setLng(convertToDouble(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("dal_civico") != null && !data.get("dal_civico").isEmpty()) {
            if (data.get("dal_civico").size()>1) throw new XSSDataException("Incorrect data cardinality for field dalCivico: expected single value.");
            
            Object item = data.get("dal_civico").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field dalCivico: expected DOMData");
                                  setDalCivico(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("al_civico") != null && !data.get("al_civico").isEmpty()) {
            if (data.get("al_civico").size()>1) throw new XSSDataException("Incorrect data cardinality for field alCivico: expected single value.");
            
            Object item = data.get("al_civico").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field alCivico: expected DOMData");
                                  setAlCivico(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("dal_intersezione") != null && !data.get("dal_intersezione").isEmpty()) {
            if (data.get("dal_intersezione").size()>1) throw new XSSDataException("Incorrect data cardinality for field dalIntersezione: expected single value.");
            
            Object item = data.get("dal_intersezione").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field dalIntersezione: expected DOMData");
                                  setDalIntersezione(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("al_intersezione") != null && !data.get("al_intersezione").isEmpty()) {
            if (data.get("al_intersezione").size()>1) throw new XSSDataException("Incorrect data cardinality for field alIntersezione: expected single value.");
            
            Object item = data.get("al_intersezione").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field alIntersezione: expected DOMData");
                                  setAlIntersezione(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("tipologia") != null && !data.get("tipologia").isEmpty()) {
            if (data.get("tipologia").size()>1) throw new XSSDataException("Incorrect data cardinality for field tipologia: expected single value.");
            
            Object item = data.get("tipologia").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field tipologia: expected DOMData");
                                  setTipologia(convertToString(((DOMData)item).getStringValue()));
                                      }
                  }  

    
    public eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.Ordinanzerovereto.Via buildMessage() {
      eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.Ordinanzerovereto.Via .Builder builder = eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.Ordinanzerovereto.Via .newBuilder();
                        if (getCodiceVia() != null) {
      	builder.setCodiceVia(getCodiceVia());
      }
                                    if (getDescrizioneVia() != null) {
      	builder.setDescrizioneVia(getDescrizioneVia());
      }
                                    if (getNote() != null) {
      	builder.setNote(getNote());
      }
                                    if (getLat() != null) {
      	builder.setLat(getLat());
      }
                                    if (getLng() != null) {
      	builder.setLng(getLng());
      }
                                    if (getDalCivico() != null) {
      	builder.setDalCivico(getDalCivico());
      }
                                    if (getAlCivico() != null) {
      	builder.setAlCivico(getAlCivico());
      }
                                    if (getDalIntersezione() != null) {
      	builder.setDalIntersezione(getDalIntersezione());
      }
                                    if (getAlIntersezione() != null) {
      	builder.setAlIntersezione(getAlIntersezione());
      }
                                    if (getTipologia() != null) {
      	builder.setTipologia(getTipologia());
      }
                        return builder.buildPartial();
    }
    
    
  }

 
  protected static double convertToDouble(String value) {
    return Double.parseDouble(value);
  }
  
  protected static float convertToFloat(String value) {
    return Float.parseFloat(value);
  }

  protected static boolean convertToBoolean(String value) {
    return Boolean.parseBoolean(value);
  }

  protected static String convertToString(String value) {
    return value;
  }

  protected static int convertToInteger(String value) {
    return Integer.parseInt(value);
  }

  protected static long convertToLong(String value) {
    return Long.parseLong(value);
  }

  protected static ByteString convertToByteString(String value) {
    try {
      return ByteString.copyFrom(value.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
      return ByteString.copyFrom(value.getBytes());
    }
  }
 
}

/*******************************************************************************
 * Copyright 2012-2013 Trento RISE
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 ******************************************************************************/
package eu.trentorise.smartcampus.services.ordinanzerovereto.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.Ordinanzerovereto.Ordinanza;
import eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.Ordinanzerovereto.Via;

public class Script {

	@SuppressWarnings("unchecked")
	public List<?> createOrdinanze(String data) {
		List<Ordinanza> result = new ArrayList<Ordinanza>();
		try {
			List<Map> list = new ObjectMapper().readValue(data, List.class);
			for (Map<String,Object> ord : list) {
				Ordinanza.Builder builder = Ordinanza.newBuilder();
				builder.setId(ord.get("DIR_DOCIDE").toString());
				builder.setAl(convertDate(ord.get("PERIODO_AL").toString()));
				builder.setDal(convertDate(ord.get("PERIODO_DAL").toString()));
				builder.setData(convertDate(ord.get("REG_DATA").toString()));
				builder.setOgetto(ord.get("DOC_OGG").toString());
				builder.setStato(ord.get("STATO_ORDINANZA").toString());
				builder.setTipologia(ord.get("TIPO_ORDINANZA").toString());
				List<Map<String,Object>> vie = (List<Map<String, Object>>) ord.get("VIE");
				List<Via> vieList = new ArrayList<Via>();
				if (vie != null) {
					for (Map<String,Object> viaMap : vie) {
						if (viaMap.get("LATITUDINE") == null || viaMap.get("LONGITUDINE").toString().isEmpty()) continue;
						Via via = Via.newBuilder()
								.setAlCivico(notNull(viaMap.get("AL_CIVICO")).toString())
								.setAlIntersezione(notNull(viaMap.get("ALL_INTERSEZIONE")).toString())
								.setCodiceVia(notNull(viaMap.get("COD_VIA")).toString())
								.setDalCivico(notNull(viaMap.get("DAL_CIVICO")).toString())
								.setDalIntersezione(notNull(viaMap.get("DALL_INTERSEZIONE")).toString())
								.setNote(notNull(viaMap.get("NOTA_VIA")).toString())
								.setDescrizioneVia(notNull(viaMap.get("NTV_DESCR")).toString())
								.setLat(Double.parseDouble((viaMap.get("LATITUDINE")).toString()))
								.setLng(Double.parseDouble((viaMap.get("LONGITUDINE")).toString()))
								.setTipologia(notNull(viaMap.get("TIPOLOGIA")).toString())
								.build();
						vieList.add(via);
					}
					builder.addAllVie(vieList);
				}
				result.add(builder.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private String convertDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		Date newDate = sdf.parse(date);
		Calendar cal = new GregorianCalendar();
		cal.setTime(newDate);
		return cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
	}
	
	private Object notNull(Object s) {
		return s == null ? "" : s;
	}	
	
	@SuppressWarnings("unchecked")
	public List<?> oldCreateOrdinanze(String data) {
		List<Ordinanza> result = new ArrayList<Ordinanza>();
		String txt = preprocess(data);
		try {
			Map<String,Object> map = new ObjectMapper().readValue(txt, Map.class);
			List<Map<String,Object>> list = (List<Map<String, Object>>) map.get("atti");
			for (Map<String,Object> elem : list) {
				Map<String,Object> props = (Map<String, Object>) elem.get("properties");
				Ordinanza.Builder builder = Ordinanza.newBuilder();
				builder.setId(props.get("id").toString());
				builder.setAl(props.get("to").toString());
				builder.setDal(props.get("from").toString());
				builder.setData(props.get("data").toString());
				builder.setOgetto(props.get("oggetto").toString());
				builder.setStato(props.get("stato").toString());
				builder.setTipologia(props.get("tipologia").toString());
				List<Map<String,Object>> vie = (List<Map<String, Object>>) props.get("vie");
				List<Via> vieList = new ArrayList<Via>();
				if (vie != null) {
					for (Map<String,Object> viaMap : vie) {
						if (viaMap.get("lat") == null || viaMap.get("lat").toString().isEmpty()) continue;
						Via via = Via.newBuilder()
								.setAlCivico(viaMap.get("al_civico").toString())
								.setAlIntersezione(viaMap.get("all_intersezione").toString())
								.setCodiceVia(viaMap.get("codice_via").toString())
								.setDalCivico(viaMap.get("dal_civico").toString())
								.setDalIntersezione(viaMap.get("dall_intersezione").toString())
								.setNote(viaMap.get("note").toString())
								.setDescrizioneVia(viaMap.get("descrizione_via").toString())
								.setLat(Double.parseDouble(viaMap.get("lat").toString()))
								.setLng(Double.parseDouble(viaMap.get("lon").toString()))
								.setTipologia(viaMap.get("tipologia").toString())
								.build();
						vieList.add(via);
					}
					builder.addAllVie(vieList);
				}
				result.add(builder.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Convert strange input format to JSON
	 * @param txt
	 * @return
	 */
	private static String preprocess(String txt) {
		txt = txt.replace("\t", "");
		txt = txt.replace("\n", "");
		txt = txt.replace("\r", "");
		// strange array to JSON object
		txt = txt.replace("[\"", "{\"");
		txt = txt.replace("],", "},");
		// strange object to array
		txt = txt.replace("\"vie\": {", "\"vie\": [");
		txt = txt.replace("}}}", "]}}");
		while (txt.indexOf("\"dal\"") >= 0) {
			txt = txt.replaceFirst("\"dal\"", "\"from\"");
			txt = txt.replaceFirst("\"dal\"", "\"to\"");
			txt = txt.replaceFirst("\"al\"", "\"to\"");
		}
		
		
		char[] arr = txt.toCharArray();
		StringBuilder sb = new StringBuilder();
		boolean opened = false;
		for (int i = 0; i < arr.length; i++) {
			if (opened && arr[i] == '"' && arr[i+1] != ',' && arr[i+1] != ':') {
				sb.append("\\\"");
			} else if (opened || arr[i]!=' ') {
				sb.append(arr[i]);
			}
			
			if (arr[i] == '"' && (arr[i+1] == ',' || arr[i+1] == ':')) {
				opened = false;
			} else if (arr[i] == '"' && ! opened) {
				opened = true;
			}

			if ((arr[i]=='}' || arr[i]==']') && sb.charAt(sb.length()-2) == ',') {
				sb.deleteCharAt(sb.length()-2);
			}
		}
		txt = sb.toString();
		return txt;
	}

}

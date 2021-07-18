package com.xubo.Interview.sz.fourkmiles;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Xubo
 * @Date 2021/6/2 14:45
 */
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * DSP 广告投放站点
 * 数据库维护了 t_indicator_dsp_ad_site 表
 */
@Getter
public enum EDspAdSite {

        /**
         * CA("加拿大", "ca", 4, "北美", 1, 2, "CAD"),
         * DE("德国", "de", 6, "欧洲", 2, 6, "EUR"),
         * ES("西班牙", "es", 8, "欧洲", 2, 8, "EUR"),
         * FR("法国", "fr", 7, "欧洲", 2, 5, "EUR"),
         * IT("意大利", "it", 2, "欧洲", 2, 7, "EUR"),
         * MX("墨西哥", "mx", 5, "北美", 1, 3, "MXN"),
         * UK("英国", "uk", 1, "欧洲", 2, 4, "GBP"),
         * US("美国", "us", 3, "北美", 1, 1, "USD"),
         * JP("日本", "jp", 14, "亚洲", 3, 9, "JPY");
         */
        AMERICA(1, "北美区", 3, "us", "美国", "United States", "USD", "$", "America/New York", "https://www.amazon.com/dp/", "https://www.amazon.com/", "https://advertising.amazon.com/dsp/","US"),
        CA(1, "北美区", 4, "ca", "加拿大", "Canada", "CAD", "CDN$", "America/New York", "https://www.amazon.ca/dp/", "https://www.amazon.ca/", "https://advertising.amazon.com/dsp/","CA"),
        MX(1, "北美区", 5, "mx", "墨西哥", "Mexico", "MXN", "Mex.$", "America/New York", "https://www.amazon.com.mx/dp/", "https://www.amazon.com.mx/", "https://advertising.amazon.com/dsp/",null),
        BRA(1, "北美区", 25, "br", "巴西", "Brazil", "BRL", "R$", "America/New York", "https://www.amazon.com.br/dp/", "https://www.amazon.com.br/", "https://advertising.amazon.com/dsp/",null),
        UK(2, "欧洲区", 1, "uk", "英国", "United Kingdom", "GBP", "￡", "Europe/London", "https://www.amazon.co.uk/dp/", "https://www.amazon.co.uk/", "https://advertising.amazon.co.uk/dsp/","GB"),
        DE(2, "欧洲区", 6, "de", "德国", "Germany", "EUR", "€", "Europe/London", "https://www.amazon.de/dp/", "https://www.amazon.de/", "https://advertising.amazon.co.uk/dsp/","DE"),
        FR(2, "欧洲区", 7, "fr", "法国", "France", "EUR", "€", "Europe/London", "https://www.amazon.fr/dp/", "https://www.amazon.fr/", "https://advertising.amazon.co.uk/dsp/","FR"),
        IT(2, "欧洲区", 2, "it", "意大利", "Italy", "EUR", "€", "Europe/London", "https://www.amazon.it/dp/", "https://www.amazon.it/", "https://advertising.amazon.co.uk/dsp/","IT"),
        ES(2, "欧洲区", 8, "es", "西班牙", "Spain", "EUR", "€", "Europe/London", "https://www.amazon.es/dp/", "https://www.amazon.es/", "https://advertising.amazon.co.uk/dsp/","ES"),
        IN(2, "欧洲区", 20, "in", "印度", "India", "INR", "₹", "Europe/London", "https://www.amazon.in/dp/", "https://www.amazon.in/", "https://advertising.amazon.co.uk/dsp/","IN"),
        AE(2, "欧洲区", 21, "ae", "阿联酋", "United Arab Emirates", "AED", "AED", "Europe/London", "https://www.amazon.ae/dp/", "https://www.amazon.ae/", "https://advertising.amazon.co.uk/dsp/",null),
        SA(2, "欧洲区", 22, "sa", "沙特阿拉伯", "Saudi Arab", "SAR", "ريال", "Europe/London", "https://saudi.souq.com/sa-ar/dp/", "https://saudi.souq.com/sa-ar/", "https://advertising.amazon.co.uk/dsp/",null),
        NL(2, "欧洲区", 24, "nl", "荷兰", "Netherland", "EUR", "€", "Europe/London", "https://www.amazon.nl/dp/", "https://www.amazon.nl/", "https://advertising.amazon.co.nl/dsp/",null),
        JP(3, "亚洲区", 14, "jp", "日本", "Japan", "JPY", "JPY￥", "Asia/Tokyo", "https://www.amazon.co.jp/dp/", "https://www.amazon.co.jp/", "https://advertising.amazon.co.jp/dsp/","JP"),
        AU(3, "亚洲区", 23, "au", "澳大利亚", "Australia", "AUD", "AU$", "Asia/Tokyo", "https://www.amazon.com.au/dp/", "https://www.amazon.com.au/", "https://advertising.amazon.co.jp/dsp/","AU"),
        CH(3, "亚洲区", -1, "zh", "中国", "China", "CNY", "￥", "Asia/ShangHai", "", null, null,"CN"),
        HK(3, "亚洲区", -2, "hk", "中国香港", "HongKong", "HKD", "HK$", null, "", null, null,null);

        Integer areaId;
        String areaName;
        Integer id;
        String site;
        String siteName;
        String country;
        String currency;
        String currencyUnit;
        String timeZone;
        String asinUrl;
        String siteUrl;
        String dspUrl;
        String amazonSite;

        EDspAdSite(Integer areaId, String areaName, Integer id, String site, String siteName, String country, String currency, String currencyUnit, String timeZone, String asinUrl, String siteUrl, String dspUrl,String amazonSite) {
            this.areaId = areaId;
            this.areaName = areaName;
            this.siteName = siteName;
            this.id = id;
            this.site = site;
            this.country = country;
            this.currency = currency;
            this.currencyUnit = currencyUnit;
            this.timeZone = timeZone;
            this.asinUrl = asinUrl;
            this.siteUrl = siteUrl;
            this.dspUrl = dspUrl;
            this.amazonSite = amazonSite;
        }

        public static List<JSONObject> l() {
            List<JSONObject> list = new ArrayList<>();
            for (EDspAdSite e : EDspAdSite.values())
                list.add(new JSONObject().fluentPut("id", e.getId()).fluentPut("name", e.getCountry()));
            list = list.stream().filter(x -> x.getInteger("id") > 0).collect(Collectors.toList());
            return list;
        }

        public static EDspAdSite v(Integer id) {
            if (id == null) return null;
            for (EDspAdSite e : values()) if (e.getId() == id) return e;
            return null;
        }

        public static String getAreaName(Integer areaId) {
            if (areaId == null) return null;
            for (EDspAdSite e : values()) if (e.getAreaId() == areaId) return e.getAreaName();
            return null;
        }

        public static String getSiteName(Integer siteId) {
            if (siteId == null) return null;
            for (EDspAdSite e : values()) if (e.getId() == siteId) return e.getSite();
            return null;
        }

        public static String getSiteRelName(Integer siteId) {
            if (siteId == null) return null;
            for (EDspAdSite e : values()) if (e.getId() == siteId) return e.getSiteName();
            return null;
        }

        public static String getSiteNameBySite(String site) {
            if (site == null) return null;
            for (EDspAdSite e : values()) if (StringUtils.equalsIgnoreCase(e.getSite(),site)) return e.getSiteName();
            return null;
        }

        public static Optional<EDspAdSite> of(Integer id) {
            return Arrays.stream(EDspAdSite.values()).filter(e -> e.getId().equals(id)).findFirst();
        }

        public static Integer getSiteIdBySite(String site) {
            if (site == null) return null;
            for (EDspAdSite e : values()) if (e.getSite().equalsIgnoreCase(site)) return e.getId();
            return null;
        }

        public static Integer getSiteIdByAmaSite(String amaSite) {
            if (amaSite == null) return null;
            for (EDspAdSite e : values()) if (StringUtils.equalsIgnoreCase(amaSite,e.getAmazonSite())) return e.getId();
            return null;
        }

        public static Integer getSiteId(String siteName) {
            if (siteName == null) return null;
            for (EDspAdSite e : values()) if (e.getSite().equals(siteName)) return e.getId();
            return null;
        }

        public static Integer getAreaIdBySite(String siteName) {
            if (siteName == null) return null;
            for (EDspAdSite e : values()) if (e.getSite().equals(siteName)) return e.getAreaId();
            return null;
        }

        public static Integer getAreaIdBySiteId(Integer siteId) {
            if (siteId == null) return null;
            for (EDspAdSite e : values()) if (e.getId().equals(siteId)) return e.getAreaId();
            return null;
        }

        public static String getCurrency(Integer siteId) {
            if (siteId == null) return null;
            for (EDspAdSite e : values()) if (e.getId() == siteId) return e.getCurrency();
            return null;
        }

        public static Integer getSiteIdByCurrency(String currency) {
            if (currency == null) return null;
            for (EDspAdSite e : values()) if (currency.equals(e.getCurrency())) return e.getId();
            return null;
        }

        public static String getCurUnitByCur(String currency) {
            Optional<EDspAdSite> site = Arrays.stream(EDspAdSite.values()).filter(e -> e.getCurrency().equals(currency)).findFirst();
            if (!site.isPresent()) {
                /*List<ESite> eSiteList = ESite.getByCurrency(currency);
                if(CollectionUtils.isNotEmpty(eSiteList)){
                    return eSiteList.get(0).getCurrencyUnit();
                }*/
            }
            return site.isPresent() ? site.get().getCurrencyUnit() : currency;
        }

        public static String getCurUnitBySite(String siteName) {
            if (siteName == null) return null;
            for (EDspAdSite e : values()) if (e.getSite().equals(siteName)) return e.getCurrencyUnit();
            return null;
        }

        public static List<JSONObject> getSiteByAreaId(Integer areaId) {
            if (areaId == null) {
                return null;
            }
            List<JSONObject> siteList = new ArrayList<>();
            List<EDspAdSite> list = Arrays.stream(EDspAdSite.values()).filter(e -> e.getAreaId().equals(areaId)).collect(Collectors.toList());
            list = list.stream().filter(x -> x.getId() > 0).collect(Collectors.toList());
            list.forEach(x -> {
                JSONObject result = new JSONObject();
                result.fluentPut("siteId", x.getId())
                        .fluentPut("site", x.getSite())
                        .fluentPut("country", x.getCountry());
                siteList.add(result);
            });
            return siteList;
        }

        public static List<JSONObject> getAllArea() {
            List<JSONObject> areaList = new ArrayList<>();
            Map<Integer, List<EDspAdSite>> listMap = Arrays.stream(EDspAdSite.values()).collect(Collectors.groupingBy(EDspAdSite::getAreaId, Collectors.toList()));
            listMap.forEach((k,v) -> {
                JSONObject result = new JSONObject();
                result.fluentPut("areaId", k)
                        .fluentPut("areaName", getAreaName(k));
                areaList.add(result);
            });
            return areaList;
        }

        public static String getCurUnitBySiteEn(String site) {
            Optional<EDspAdSite> eSite = Arrays.stream(EDspAdSite.values()).filter(e -> e.getSite().equals(site)).findFirst();
            return eSite.get().getCurrencyUnit();
        }

        public static Set<JSONObject> getSiteList() {
            return Arrays.stream(EDspAdSite.values()).filter(x -> x.getId() > 0).map(e -> new JSONObject().fluentPut("id", e.getId()).fluentPut("name", e.getSite()).fluentPut("areaId",e.getAreaId())).collect(Collectors.toSet());
        }

        public static Optional<EDspAdSite> getByCurrency(String currency) {
            return Arrays.stream(EDspAdSite.values()).filter(x -> x.currency.equals(currency)).findFirst();
        }

}

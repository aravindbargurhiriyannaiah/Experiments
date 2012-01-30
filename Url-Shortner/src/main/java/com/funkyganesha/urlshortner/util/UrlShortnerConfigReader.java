package com.funkyganesha.urlshortner.util;

import com.funkyganesha.urlshortner.UrlShortnerConfig;
import com.funkyganesha.urlshortner.bean.UrlShortnerConfiguration;
import org.apache.commons.lang.StringUtils;
import org.xml.sax.SAXException;

import javax.annotation.concurrent.ThreadSafe;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.SchemaFactory;

@ThreadSafe
public class UrlShortnerConfigReader {
    private static JAXBContext jaxbContext;

    public static UrlShortnerConfiguration get() {
        return UrlShortnerConfigurationReader.urlShortnerConfiguration;
    }

    private static class UrlShortnerConfigurationReader {
        public static UrlShortnerConfiguration urlShortnerConfiguration = lazilyLoadUrlShortnerConfiguration();

        private static UrlShortnerConfiguration lazilyLoadUrlShortnerConfiguration() {
            UrlShortnerConfiguration urlShortnerConfiguration = null;
            try {
                if (jaxbContext == null) {
                    jaxbContext = JAXBContext.newInstance("com.funkyganesha.urlshortner");
                }
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                unmarshaller.setSchema(schemaFactory.newSchema(UrlShortnerConfigReader.class.getResource("/UrlShortnerConfiguration.xsd")));
                UrlShortnerConfig unmarshal = (UrlShortnerConfig) unmarshaller.unmarshal(UrlShortnerConfigReader.class.getClass().getResourceAsStream("/UrlShortnerConfiguration.xml"));
                UrlShortnerConfig.DatabaseDetails databaseDetails = unmarshal.getDatabaseDetails();
                if (databaseDetails != null) {
                    urlShortnerConfiguration = populateLightLotusConfiguration(databaseDetails);
                }
            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
            return urlShortnerConfiguration;
        }

        private static UrlShortnerConfiguration populateLightLotusConfiguration(UrlShortnerConfig.DatabaseDetails databaseDetails) {
            UrlShortnerConfiguration urlShortnerConfig = new UrlShortnerConfiguration();
            UrlShortnerConfig.DatabaseDetails.ConnectionDetails connectionDetails = databaseDetails.getConnectionDetails();
            urlShortnerConfig.setHostname(connectionDetails.getHostName().trim());
            urlShortnerConfig.setPort(connectionDetails.getPort().intValue());
            urlShortnerConfig.setCollectionName(connectionDetails.getCollectionName().trim());
            urlShortnerConfig.setDatabase(connectionDetails.getDatabaseName().trim());
            UrlShortnerConfig.DatabaseDetails.AuthenticationDetails authenticationDetails = databaseDetails.getAuthenticationDetails();
            if (authenticationDetails != null) {
                urlShortnerConfig.setUsername(authenticationDetails.getUserName().trim());
                urlShortnerConfig.setPassword(authenticationDetails.getPassword().trim());
                if (StringUtils.isNotBlank(urlShortnerConfig.getUsername()) && StringUtils.isNotBlank(urlShortnerConfig.getPassword())) {
                    urlShortnerConfig.setAuthenticationRequired(true);
                }
            }
            return urlShortnerConfig;
        }
    }

    private UrlShortnerConfigReader() {
    }
}

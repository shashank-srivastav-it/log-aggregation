package com.backend.ksqldbservice;

import com.backend.ksqldbservice.client.KsqlDbClientBuilder;
import io.confluent.ksql.api.client.Row;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class KsqlDbServiceApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(KsqlDbServiceApplication.class, args);
//        KsqlDbClientBuilder ksqlDbClientBuilder = applicationContext.getBean(KsqlDbClientBuilder.class);
//        try {
//            List<Row> rowList = ksqlDbClientBuilder.fetchQueryResults("Select * from WP_DEV_AVAILABILITY;");
//            System.out.println(populateSAPInventory(rowList));
////            List<Row> rowList = ksqlDbClientBuilder.fetchQueryResults("SELECT * FROM PERSON_STATS WHERE PERSON = 'Allison';");
////            System.out.println(rowList);
//        } catch (ExecutionException | InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

//    private static List<KsqlSAPInventory>  populateSAPInventory(List<Row> rowList ){
//        List<KsqlSAPInventory> ksqlDbInventories = new ArrayList<>();
//        for (Row row : rowList) {
//            KsqlSAPInventory resEntry = new KsqlSAPInventory();
//            resEntry.setInvPk(row.values().getValue(0).toString());//INV_PK
//            resEntry.setPlant(row.values().getValue(1).toString());//PLANT
//            resEntry.setMaterialNumber(row.values().getValue(2).toString());//MATERIAL_NUMBER
//            resEntry.setDateStock(row.values().getValue(3).toString());//DATE_STOCK
//            resEntry.setMaterialStatus(row.values().getValue(4).toString());//MATERIAL_STATUS
//            resEntry.setQtyAvailable((Double) row.values().getValue(5));//QTY_AVAILABLE
//            resEntry.setQtyTransit((Double) row.values().getValue(6));//QTY_TRANSIT
//            resEntry.setAltModel(row.values().getValue(7).toString()); //ALTMODEL
//            ksqlDbInventories.add(resEntry);
//        }
//        return ksqlDbInventories;
//    }
}
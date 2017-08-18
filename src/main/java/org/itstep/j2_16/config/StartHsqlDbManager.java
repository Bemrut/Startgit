package org.itstep.j2_16.config;

import org.hsqldb.util.DatabaseManagerSwing;

public class StartHsqlDbManager {

    public static void startDBManager() {
        DatabaseManagerSwing.main(
                new String[]{"--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "sa"});
    }
}

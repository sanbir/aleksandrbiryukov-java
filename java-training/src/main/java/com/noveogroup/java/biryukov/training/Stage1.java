package com.noveogroup.java.biryukov.training;

import com.noveogroup.java.biryukov.training.POJOs.MailMessage;
import com.noveogroup.java.biryukov.training.POJOs.POJOs;
import com.noveogroup.java.biryukov.training.POJOs.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

/**
 * The first stage including POJO generation, serialization and writing to file.
 */
final class Stage1 {

    private static final String[] VALID_EMAIL_ADDRESSES = {
        "gpfpaim@tba.com.br", "gpg@fti.com.br", "gpg@sti.com.br",
        "gpgascom1@ccinet.com.br", "gpgascom@ccinet.com.br", "gpgil@nutecnet.com.br",
        "gpgsch@essex.ac.uk", "gpguerra@rocketmail.com", "gpi12@openlink.com.br",
        "gpi1@openlink.com.br", "gpierini@fti.com.br", "gpierini@sti.com.br",
        "gpierre@mandic.com.br", "gpimenta@mymail.com.br", "gpinciro@uol.com.br",
        "gpinese@alanet.com.br", "gpinf1@ssnet.com.br", "gpinf@ssnet.com.br",
        "gpinformatica@fepesmi.peasus.com.br", "gpinheiro1@netpar.com", "gpinto@bol.com.br",
        "gpiola@zipmail.com.br", "gpires@uol.com.br", "gpisaneschi@originet.com.br",
        "gpisani@alphanet.com.br", "gpisano1@pecom.com.ar", "gpisano@pecom.com.ar",
        "gpiske@pcrj.rj.gov.br", "gpitta@furnas.com.br", "gpiucco@informatec.com.br",
        "gpiva@mpc.com.br", "gpl@ibeuce.com.br", "gpl@plug-in.com.br",
        "gplmau@correionet.com.br", "gpluz@svn.com.br", "gpm1@base.com.br",
        "gpm2418@uninet.com.br", "gpm@bafe.com.br", "gpm@base.com.br",
        "gpm@dialdata.com.br", "gpm@lexxa.com.br", "gpm@netville.com.br",
        "gpm@nutecnet.com.br", "gpmaia@nitnet.com.br", "gpmarques@originet.com.br",
        "gpnucleo1@sti.com.br", "gpnucleo@sti.com.br", "gpo@cyb.com.br",
        "gpoleto@zipmail.com.br", "gpoli@uol.com.br", "gpoliver@artnet.com.br",
        "gpoliver@estaminas.com.br", "gpoliver@inetminas.estaminas.com.br", "gpontef@expert.com.br",
        "gpontes@expert.com.br", "gporpino@digi.com.br", "gport@via-rs.com.br",
        "gporta@ibm.net", "gportela@nutecnet.com.br", "gporto2@mandic.com.br",
        "gporto@mailbr.com.br", "gporto@mandic.com.br", "gporto@pobox.com",
        "gppaiva@zipmail.com.br", "gpr@zaz.com.br", "gprado@microplanet.com.br",
        "gprado@uol.com.br", "gpramos@uol.com.br", "gprbf@yahoo.com",
        "gpreis@rio.nutecnet.com.br", "gpretko@bsi.com.br", "gpretko@cwbone.bsi.com.br",
        "gprhrram@sehs01.alcatel.com.br", "gprveiga@netsite.com.br", "gps.ale@montreal.com.br",
        "gps.gpsnet@sop.com.br", "gps@cdlnet.com.br", "gps@dscdlsa.com.br",
        "gps@escelsa.com.br", "gps@uol.com.br", "gpsell@uol.com.br",
        "gpsite@gpsite.com.br", "gpsoares@openlink.com.br", "gpstec@uninet.com.br",
        "gpt@openline.com.br", "gpu@uol.com.br", "gpungan1@matrix.com.br",
        "gpvaz@ma.ultranet.com", "gpvniteroi2@interclub.com.br", "gpw@provider.com.br",
        "gqc276@secrel.com.br", "gqcastro@brasilvision.com.br", "gqimeri1@vm.uff.br",
        "gqimeri@vm.uff.br", "gqualid1@femanet.com.br", "gqualid@femanet.com.br",
        "gquatro.tur4@nox.net", "gqueiroz@barroco.com.br", "gqueiroz@ifm.com.br",
    };

    private static final String[] INVALID_EMAIL_ADDRESSES = {
        "gpt@openline.com.b", "gpu@uol.com.b", "gpungan1@matrix.com.b",
        "gpva.ultranet.com", "gpvniterointerclub.com.br", "gpwovider.com.br",
        "gqc276r", "gqcastror", "gqimer3r",
        "gqimerr", "gqualid1r", "gqualidr",
        "gquatret", "gqueiror", "gqueirozbr",
    };

    private static final String[] VALID_FIRST_NAMES = {
        "Usha", "Danelle", "Laquanda",
        "Voncile", "Winnie", "Ferdinand",
        "Clementine", "Lizzette", "Melynda",
        "Tammi", "Reggie", "Clare",
        "Jona", "Bernice", "Rosina",
        "Mozella", "Roselee", "Jolynn",
        "Milda", "Coreen", "Marceline",
        "Stacy", "Everett", "Paris",
        "Deena", "Georgie", "James",
        "Diann", "Wendell", "Erika",
        "Gertude", "Teofila", "Sherri",
        "Susanne", "Shannon", "Melisa",
        "Danna", "Chong", "Noreen",
        "Zena", "Jeneva", "Sybil",
        "Solomon", "Lena", "Riley",
        "Yuri", "Jamila", "Audrey",
    };

    private static final String[] INVALID_FIRST_NAMES = {
        "d", "4343", "fg43",
        "Vonc43ile", "Win@@nie", "Ferdi#nand",
        "Cleme!!ntine", "Lizzet''te", "Mel***ynda",
        "Tam^^^mi", "Reg^^^gie", "Cl^^^are",
        "Jo43na", "Ber43nice", "Ro43sina",
        "Moz43ella", "Rose43lee", "Jol43ynn",
        "Mi43lda", "Co43reen", "Mar43celine",
        "Stac43y", "Evere43tt", "Par43is",
        "Dee43na", "Ge43orgie", "Ja$556/mes",
        "Dian$556/n", "We$556/ndell", "Er$556/ika",
        "Gert$556/ude", "Teo$556/fila", "She$556/rri",
        "Susa$556/nne", "$556/Shannon", "M$556/elisa",
        "Dann$556/a", "Cho$556/ng", "Nore$556/en",
        "Zen+%a", "Je+%neva", "+%Sybil",
        "Solo+%mon", "L+%ena", "Ri+%ley",
        "Yu0ri", "Jami0la", "Aud7rey",
    };

    private static final String[] VALID_LAST_NAMES = {
        "Foster", "Bullard", "Wylie",
        "Hector", "Wilkinson", "Caesar",
        "Polson", "Close", "Buzzard",
        "Ewing", "Kistler", "Seidner",
        "Iseman", "Hanford", "Snyder",
        "Thomas", "Hallauer", "Wall",
        "Gadow", "Dull", "Biery",
        "Tomco", "Jowers", "Todd",
        "Earhart", "Baughman", "Stough",
        "Mackendoerfer", "Swain", "Catleay",
        "O'Connor", "McDonald", "de Marco",
        "John Scott", "Koch-Mehrin",
    };

    private static final String[] INVALID_LAST_NAMES = {
        "Fos3ter", "Bull3ard", "W4ylie",
        "Hect34or", "Wilki34nson", "Caes434ar",
        "Polso23n", "Cl@@ose", "B$$uzzard",
        "Ewi^ng", "Ki*stler", "Sei+dner",
        "Isem&an", "Han?ford", "S>nyder",
        "Tho<mas", "Halla|uer", "Wa\\ll",
        "Gado//w", "Du23ll", "Bi43ery",
        "Tomc435o", "Jo345wers", "Tod345d",
        "Earh45art", "Ba45ughman", "St3ough",
        "Mackendo45erfer", "S53wain", "435Catleay",
        "O'Conno35r", "M455cDonald", "de M54arco",
        "John 45Scott", "Koch34-Mehrin",
    };

    private static final int[] YEARS = {1970, 2013, 2020, };

    private static final int MONTH = 12;

    private static final int DAY = 28;

    private static final int INTERVAL = 10;

    private static final Scanner SCANNER = UTF8Scanner.getScanner();

    private static final Random RANDOM = new Random();

    private Stage1() { }

    /**
     *  The first stage including POJO generation, serialization and writing to file.
     */
    public static void stage1() throws IOException {
        final Collection<Object> pojosToWrite = new LinkedList<Object>();

        /* Receiving user input */
        int n;
        System.out.println("How many VALID Mail Messages would you like to get?");
        n = SCANNER.nextInt();
        for (int i = 0; i < n; i++) {
            pojosToWrite.add(generateValidPojo(POJOs.MailMessage));
        }
        System.out.println("How many INVALID Mail Messages would you like to get?");
        n = SCANNER.nextInt();
        for (int i = 0; i < n; i++) {
            pojosToWrite.add(generateInvalidPojo(POJOs.MailMessage));
        }
        System.out.println("How many VALID Persons would you like to get?");
        n = SCANNER.nextInt();
        for (int i = 0; i < n; i++) {
            pojosToWrite.add(generateValidPojo(POJOs.Person));
        }
        System.out.println("How many INVALID Persons would you like to get?");
        n = SCANNER.nextInt();
        for (int i = 0; i < n; i++) {
            pojosToWrite.add(generateInvalidPojo(POJOs.Person));
        }

        /* Persisting data */

        final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serial.bin"));
        for (Object obj : pojosToWrite) {
            oos.writeObject(obj);
        }
        oos.close();
    }

    /**
     *  POJO is automatically randomly generated from existing classes
     * in training.POJOs package.
     * Its fields are filled using static arrays
     * There are currently only 2 types for POJOs: MailMessage and Person.
     * Here only valid POJO is generated.
     * For invalid one use 'generateInvalidPojo' method.
     */
    private static Object generateValidPojo(final POJOs pojoType) {
        int index;

        if (pojoType == POJOs.MailMessage) {
            final MailMessage pojo = new MailMessage();
            pojo.setFrom(VALID_EMAIL_ADDRESSES[RANDOM.nextInt(VALID_EMAIL_ADDRESSES.length)]);
            pojo.setTo(VALID_EMAIL_ADDRESSES[RANDOM.nextInt(VALID_EMAIL_ADDRESSES.length)]);
            index = RANDOM.nextInt(VALID_EMAIL_ADDRESSES.length);
            pojo.setCC(Arrays.copyOfRange(VALID_EMAIL_ADDRESSES,
                    index,
                    index + RANDOM.nextInt(VALID_EMAIL_ADDRESSES.length - index)));
            index = RANDOM.nextInt(VALID_EMAIL_ADDRESSES.length);
            pojo.setBcc(Arrays.copyOfRange(VALID_EMAIL_ADDRESSES,
                    index,
                    index + RANDOM.nextInt(VALID_EMAIL_ADDRESSES.length - index)));

            pojo.setDate(SettingTime.setTime(YEARS[1],
                    RANDOM.nextInt(MONTH),
                    RANDOM.nextInt(DAY) + 1));

            pojo.setMessage("");

            return pojo;
        }

        if (pojoType == POJOs.Person) {
            final Person pojo = new Person();
            pojo.setFirstName(VALID_FIRST_NAMES[RANDOM.nextInt(VALID_FIRST_NAMES.length)]);
            pojo.setLastName(VALID_LAST_NAMES[RANDOM.nextInt(VALID_LAST_NAMES.length)]);

            pojo.setBirthDay(SettingTime.setTime(RANDOM.nextInt(INTERVAL) + YEARS[0],
                    RANDOM.nextInt(MONTH),
                    RANDOM.nextInt(DAY) + 1));

            return pojo;
        }

        return null;
    }

    /**
     *  POJO is automatically randomly generated from existing classes
     * in training.POJOs package.
     * Its fields are filled using static arrays
     * There are currently only 2 types for POJOs: MailMessage and Person.
     * Here only INvalid POJO is generated.
     * For valid one use 'generateValidPojo' method.
     */
    private static Object generateInvalidPojo(final POJOs pojoType) {
        int index;

        if (pojoType == POJOs.MailMessage) {
            final MailMessage pojo = new MailMessage();
            pojo.setFrom(INVALID_EMAIL_ADDRESSES[RANDOM.nextInt(INVALID_EMAIL_ADDRESSES.length)]);
            pojo.setTo(VALID_EMAIL_ADDRESSES[RANDOM.nextInt(VALID_EMAIL_ADDRESSES.length)]);
            index = RANDOM.nextInt(VALID_EMAIL_ADDRESSES.length);
            pojo.setCC(Arrays.copyOfRange(VALID_EMAIL_ADDRESSES,
                    index,
                    index + RANDOM.nextInt(VALID_EMAIL_ADDRESSES.length - index)));
            index = RANDOM.nextInt(INVALID_EMAIL_ADDRESSES.length);
            pojo.setBcc(Arrays.copyOfRange(INVALID_EMAIL_ADDRESSES,
                    index,
                    index + RANDOM.nextInt(INVALID_EMAIL_ADDRESSES.length - index)));

            pojo.setDate(SettingTime.setTime(YEARS[1],
                    RANDOM.nextInt(MONTH),
                    RANDOM.nextInt(MONTH) + 1));

            pojo.setMessage("");

            return pojo;
        }
        if (pojoType == POJOs.Person) {
            final Person pojo = new Person();
            pojo.setFirstName(INVALID_FIRST_NAMES[RANDOM.nextInt(INVALID_FIRST_NAMES.length)]);
            pojo.setLastName(INVALID_LAST_NAMES[RANDOM.nextInt(INVALID_LAST_NAMES.length)]);

            pojo.setBirthDay(SettingTime.setTime(RANDOM.nextInt(INTERVAL) + YEARS[2],
                    RANDOM.nextInt(MONTH),
                    RANDOM.nextInt(DAY) + 1));

            return pojo;
        }

        return null;
    }

    /**
     * Sets time as year, month and day.
     */
    private static class SettingTime {
        public static Date setTime(final int year, final int month, final int dayOfMonth) {
            final Calendar cal = new GregorianCalendar(year, month, dayOfMonth);
            return cal.getTime();
        }
    }
}

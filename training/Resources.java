package training;

/**
 *  This class just stores a few static arrays of valid/invalid values for POJOs' fields
 */
public class Resources {
    
    public static final String[] VALID_EMAIL_ADDRESSES = {
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
"gquatro.tur4@nox.net", "gqueiroz@barroco.com.br", "gqueiroz@ifm.com.br"
    };
        
        public static final String[] INVALID_EMAIL_ADDRESSES = {
"gpt@openline.com.b", "gpu@uol.com.b", "gpungan1@matrix.com.b", 
"gpva.ultranet.com", "gpvniterointerclub.com.br", "gpwovider.com.br", 
"gqc276r", "gqcastror", "gqimerr", 
"gqimerr", "gqualid1r", "gqualidr", 
"gquatret", "gqueiror", "gqueirozbr" 
        };
        
        public static final String[] VALID_FIRST_NAMES = {
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
"Yuri", "Jamila", "Audrey"
        };
        
        public static final String[] INVALID_FIRST_NAMES = {
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
"Yu0ri", "Jami0la", "Aud7rey"
        };
        
        public static final String[] VALID_LAST_NAMES = {
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
"John Scott", "Koch-Mehrin"
        };
        
        public static final String[] INVALID_LAST_NAMES = {
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
"John 45Scott", "Koch34-Mehrin"
        };
        
}

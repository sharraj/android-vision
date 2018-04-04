package com.google.android.gms.samples.vision.barcodereader;

//package com.google.api.services.samples.books.cmdline;


/**
 * API key found in the <a href="https://code.google.com/apis/console?api=books">Google apis
 * console</a>.
 *
 * <p>
 * Once at the Google apis console, click on "Add project...". If you've already set up a project,
 * you may use that one instead, or create a new one by clicking on the arrow next to the project
 * name and click on "Create..." under "Other projects". Finally, click on "API Access". Look for
 * the section at the bottom called "Simple API Access".
 * </p>
 *
 * @author Ravi Mistry
 */
public class ClientCredentials {

    /** Value of the "API key" shown under "Simple API Access". */
    static final String API_KEY =
            "AIzaSyAEkQlfuwEAirqESobBbmp--WUU2-VXn1w";

    static void errorIfNotSpecified() {
        if (API_KEY.startsWith("Enter ")) {
            System.err.println(API_KEY);
            System.exit(1);
        }
    }
}


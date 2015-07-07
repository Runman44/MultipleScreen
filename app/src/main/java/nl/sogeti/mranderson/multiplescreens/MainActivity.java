package nl.sogeti.mranderson.multiplescreens;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Width for the Nexus 5 = 392dp
        // Height for the Nexus 5 = 697dp

        // You can see that the Nexus 5 has 400dp in width available so it uses the w400dp file in landscape mode
        // You can see that the Nexus 5 has 400dp in height available so it uses the h400dp file in portrait mode

        // Play around with the folders and devices.
    }
}

package menu.com.skyshare;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    homrPage hp=new homrPage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.fragment_container)!=null)
        {

            hp.setArguments(getIntent().getExtras());

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);

            ft.add(R.id.fragment_container, hp, "HomePage");
            ft.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void signUp(View view) {
        Signup sp=new Signup();
        sp.setArguments(getIntent().getExtras());
        Toast.makeText(getApplicationContext(),"creation of oblect",Toast.LENGTH_SHORT).show();
        FragmentTransaction ft =getSupportFragmentManager().beginTransaction();



        //ft.remove(ff);
       // Toast.makeText(getApplicationContext(),"frist fragment removed",Toast.LENGTH_SHORT).show();
        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        //Toast.makeText(getApplicationContext(),"animation called",Toast.LENGTH_SHORT).show();
        ft.replace(R.id.fragment_container, sp, "Signup");
        ft.addToBackStack(null);
        ft.commit();
        //Toast.makeText(getApplicationContext(),"end",Toast.LENGTH_SHORT).show();

    }

    public void Login(View view){
        Login lg=new Login();

        lg.setArguments(getIntent().getExtras());
        Toast.makeText(getApplicationContext(),"creation of oblect",Toast.LENGTH_SHORT).show();
        FragmentTransaction ft =getSupportFragmentManager().beginTransaction();



        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        ft.replace(R.id.fragment_container, lg, "login");
        ft.addToBackStack(null);
        ft.commit();

    }
}

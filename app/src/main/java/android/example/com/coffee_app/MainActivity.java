package android.example.com.coffee_app;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */


public class MainActivity extends AppCompatActivity {

    int numCoffee = 0;
    int coffeePrice = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText gratuity_view = (EditText) findViewById(R.id.gratuity_view);

        if(gratuity_view.getText().length() > 0){
            double gratuity = Double.parseDouble(gratuity_view.getText().toString());
            displayPrice(numCoffee * (coffeePrice  + gratuity));
        }

        else {
            displayPrice(numCoffee * coffeePrice);
        }
    }

    public void increment(View view){
        numCoffee++;
        display(numCoffee);
    }

    public void decrement(View view){
        if(numCoffee>0){
            numCoffee--;
        }
        display(numCoffee);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(double number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}



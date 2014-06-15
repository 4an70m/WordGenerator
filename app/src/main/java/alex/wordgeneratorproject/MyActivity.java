package alex.wordgeneratorproject;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MyActivity extends Activity {

    NewWord newWord;
    EditText newWordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        TextView infoTextView = (TextView)findViewById(R.id.textView);
        //sets some information to the help textView
        infoTextView.setText("Tip!\n" +
                "This is a test program.\n" +
                "It generates a new random word with random letters.\n" +
                "Free to use.");
         newWord = new NewWord();
    }

    public void buttonGenerateClick(View view)
    {
        newWordEditText = (EditText)findViewById(R.id.editText);
        newWord.generate();
        newWordEditText.setText("");
        newWordEditText.setText(newWord.toString());
    }

    public void buttonCopyClick(View view)
    {
        newWordEditText = (EditText)findViewById(R.id.editText);
        String textToBuffer = newWordEditText.getText().toString();
        ClipboardManager clipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("label", textToBuffer);
        clipboard.setPrimaryClip(clipData);
    }
}

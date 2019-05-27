package edu.cnm.deepdive.geoquizremake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
//app compat activity is a subclass of activity that provides compatibility for older versions of android

public class QuizActivity extends AppCompatActivity {

  private Button mTrueButton;
  private Button mFalseButton;
  private Button mNextButton;
  private Button mQuestionTextView;

  private Question[] mQuestionBank = new Question[] {
      new Question(R.string.question_australia, true),
      new Question(R.string.question_oceans, true),
      new Question(R.string.question_mideast, false),
      new Question(R.string.question_africa, false),
      new Question(R.string.question_americas, true),
      new Question(R.string.question_asia, true),
  };

  private int mCurrentIndex = 0;


  @Override
//  This method is called when an instance of the activity subclass is created. When an activity is created
//  it needs a UI to manage. To get this activity its UI, you call the Activity method setContentView
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//    the following method inflates a layout and puts it on screen
    setContentView(R.layout.activity_quiz);

    //initiates the true button field with R.class
    // implements anonymous inner class to make a listener
    // This method accepts a resource id of a widget and returns a View object.
    mTrueButton = findViewById(R.id.true_button);
    // This method takes a listener as its argument
    mTrueButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast toast = Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
      }
    });

    //initiates the false button field with R.class
    // implements anonymous inner class to make a listener
    mFalseButton = findViewById(R.id.false_button);
    mFalseButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast toast = Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
      }

    });

    mNextButton = findViewById(R.id.next_button);
    mNextButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
        int question = mQuestionBank[mCurrentIndex].gettextResId();
        mQuestionTextView.setText(question);
      }
    });
  }
}

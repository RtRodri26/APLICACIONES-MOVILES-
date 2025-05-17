package com.example.appcuestionario



import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private lateinit var tvQuestion: TextView
    private lateinit var rbOption1: RadioButton
    private lateinit var rbOption2: RadioButton
    private lateinit var rbOption3: RadioButton
    private lateinit var rbOption4: RadioButton
    private lateinit var btnNext: Button
    private lateinit var rgOptions: RadioGroup
    private lateinit var tvScore: TextView

    private var questionList: ArrayList<Question> = QuestionBank.getQuestions()
    private var currentPosition = 0
    private var score = 0
    private var username: String = ""
    private var selectedOptionIndex: Int = -1
    private var isAnswered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        tvQuestion = findViewById(R.id.tv_question)
        rbOption1 = findViewById(R.id.rb_option1)
        rbOption2 = findViewById(R.id.rb_option2)
        rbOption3 = findViewById(R.id.rb_option3)
        rbOption4 = findViewById(R.id.rb_option4)
        btnNext = findViewById(R.id.btn_next)
        rgOptions = findViewById(R.id.rg_options)
        tvScore = findViewById(R.id.tv_score)

        username = intent.getStringExtra("USER_NAME") ?: "Usuario"

        loadQuestion()

        btnNext.setOnClickListener {
            if (!isAnswered) {
                if (selectedOptionIndex != -1) {
                    checkAnswer()
                    isAnswered = true
                    btnNext.text = if (currentPosition == questionList.lastIndex) "Finalizar" else "Siguiente"
                } else {
                    Toast.makeText(this, "Por favor selecciona una opción", Toast.LENGTH_SHORT).show()
                }
            } else {
                currentPosition++
                if (currentPosition < questionList.size) {
                    loadQuestion()
                } else {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("USER_NAME", username)
                    intent.putExtra("SCORE", score)
                    intent.putExtra("TOTAL_QUESTIONS", questionList.size)
                    startActivity(intent)
                    finish()
                }
            }
        }

        rgOptions.setOnCheckedChangeListener { group, checkedId ->
            selectedOptionIndex = group.indexOfChild(findViewById(checkedId))
        }
    }

    private fun checkAnswer() {
        val correctAnswer = questionList[currentPosition].correctAnswer
        val selectedRadioButton = findViewById<RadioButton>(rgOptions.checkedRadioButtonId)
        val selectedAnswerIndex = rgOptions.indexOfChild(selectedRadioButton)

        if (selectedAnswerIndex == correctAnswer) {
            score++
            selectedRadioButton.setBackgroundColor(Color.GREEN)
        } else {
            selectedRadioButton.setBackgroundColor(Color.RED)
            val correctRadioButton = rgOptions.getChildAt(correctAnswer) as RadioButton
            correctRadioButton.setBackgroundColor(Color.GREEN)
        }

        tvScore.text = "Puntaje: $score"
    }

    private fun loadQuestion() {
        val question = questionList[currentPosition]
        tvQuestion.text = "${currentPosition + 1}. ${question.text}"
        rbOption1.text = question.options[0]
        rbOption2.text = question.options[1]
        rbOption3.text = question.options[2]
        rbOption4.text = question.options[3]

        rgOptions.clearCheck()
        for (i in 0 until rgOptions.childCount) {
            val radioButton = rgOptions.getChildAt(i) as RadioButton
            radioButton.setBackgroundColor(Color.TRANSPARENT)
        }

        tvScore.text = "Puntaje: $score"
        selectedOptionIndex = -1
        isAnswered = false
        btnNext.text = "Confirmar"
    }
}


package com.example.mytrainingsession

class ExerciseDataBase {
    companion object {
        val exercises = mutableListOf(
            Exercise(
                "Выпад",
                "И. П. - выпад вперед, другая немного согнута. После 3-4 пружинистых покачиваний " +
                        "менять положение ног прыжком. Повторить 6-8 раз в среднем темпе.",
                30,
                R.drawable.lunges
            ),
            Exercise(
                "Пистолет",
                "И.п. – стоя боком с опорой рукой о стену, подоконник, гимнастическую стенку. " +
                        "Приседание поочередно на одной и другой ноге. Фиксируется количество приседаний.",
                30,
                R.drawable.crossfit_pistol_squat
            )
        )
    }
}
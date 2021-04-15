class TennisGame1(private val playerOneName: String, private val playerTwoName: String) : TennisGame {

    private var playerOneScore: Int = 0
    private var playerTwoScore: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName === playerOneName)
            playerOneScore++
        else
            playerTwoScore++
    }

    override fun getScore(): String {
        if (playerOneScore == playerTwoScore) return equalPlayerScore()
        if (playerOneScore >= 4 || playerTwoScore >= 4) return advantageOrWinForPlayer()
        return scoringGame()
    }

    private fun scoringGame() = getPlayerScore(playerOneScore) + "-" + getPlayerScore(playerTwoScore)

    private fun equalPlayerScore(): String {
        return if (playerOneScore >= 3) "Deuce"
        else "${getPlayerScore(playerOneScore)}-All"
    }

    private fun advantageOrWinForPlayer(): String {
        val scoreDifference = playerOneScore - playerTwoScore
        return when {
            (scoreDifference == 1) -> "Advantage $playerOneName"
            (scoreDifference == -1) -> "Advantage $playerTwoName"
            (scoreDifference >= 2) -> "Win for $playerOneName"
            else -> "Win for $playerTwoName"
        }
    }

    private fun getPlayerScore(score: Int): String {
        return when (score) {
            0 -> "Love"
            1 -> "Fifteen"
            2 -> "Thirty"
            else -> "Forty"
        }
    }
}

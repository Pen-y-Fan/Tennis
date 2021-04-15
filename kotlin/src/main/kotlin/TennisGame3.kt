class TennisGame3(
    private val playerOneName: String,
    private val playerTwoName: String
) : TennisGame {

    private var playerOneScore: Int = 0
    private var playerTwoScore: Int = 0
    private val score = arrayOf("Love", "Fifteen", "Thirty", "Forty")

    override fun getScore(): String {
        if (isScoringGame()) return getPlayersScore()

        if (arePlayersScoresEqual()) return "Deuce"

        return if (isGameAtAdvantage()) "Advantage ${getLeadingPlayer()}" else "Win for ${getLeadingPlayer()}"
    }

    private fun getPlayersScore() = if (arePlayersScoresEqual()) "${score[playerOneScore]}-All"
    else "${score[playerOneScore]}-${score[playerTwoScore]}"

    private fun isGameAtAdvantage() = (playerOneScore - playerTwoScore) * (playerOneScore - playerTwoScore) == 1

    private fun isScoringGame() = playerOneScore < 4 && playerTwoScore < 4 && playerOneScore + playerTwoScore != 6

    private fun getLeadingPlayer() = if (playerOneScore > playerTwoScore) playerOneName else playerTwoName

    private fun arePlayersScoresEqual() = playerOneScore == playerTwoScore

    override fun wonPoint(playerName: String) {
        if (playerName === playerOneName) playerOneScore++ else playerTwoScore++
    }
}

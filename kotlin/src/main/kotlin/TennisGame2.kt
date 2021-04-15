import kotlin.math.absoluteValue

class TennisGame2(private val player1Name: String, private val player2Name: String) : TennisGame {
    private var playerOnePoints: Int = 0
    private var playerTwoPoints: Int = 0

    private val scores: Array<String> = arrayOf("Love", "Fifteen", "Thirty", "Forty")

    override fun getScore(): String {

        if (isEqualGame()) return getEqualScore()

        if (isLoveGame()) return getLoveScore()

        if (isScoringGame()) return getPlayersScore()

        if (isWinningGame()) return getWinningPlayer()

        return getAdvantagePlayer()
    }

    private fun getAdvantagePlayer(): String {
        return if (doesPlayerOneHaveHigherScore()) "Advantage $player1Name" else "Advantage $player2Name"
    }

    private fun getWinningPlayer(): String {
        return if (doesPlayerOneHaveHigherScore()) "Win for $player1Name" else "Win for $player2Name"
    }

    private fun isWinningGame() = ((playerOnePoints >= 4 || playerTwoPoints >= 4)
            && (playerOnePoints - playerTwoPoints).absoluteValue >= 2)

    private fun getPlayersScore() = "${scores[playerOnePoints]}-${scores[playerTwoPoints]}"

    private fun isScoringGame() = playerOnePoints in (playerTwoPoints + 1)..3 || playerTwoPoints in (playerOnePoints + 1)..3

    private fun getLoveScore(): String {
        return if (doesPlayerOneHaveHigherScore())
            "${scores[playerOnePoints]}-Love" else "Love-${scores[playerTwoPoints]}"
    }

    private fun doesPlayerOneHaveHigherScore() = playerOnePoints > playerTwoPoints

    private fun isLoveGame() = (playerOnePoints == 0 || playerTwoPoints == 0)
            && (playerOnePoints in 1..3 || playerTwoPoints in 1..3)

    private fun getEqualScore(): String {
        return if (playerOnePoints < 3) "${scores[playerOnePoints]}-All" else "Deuce"
    }

    private fun isEqualGame() = playerOnePoints == playerTwoPoints

    override fun wonPoint(playerName: String) {
        if (playerName === player1Name) playerOnePoints++ else playerTwoPoints++
    }
}
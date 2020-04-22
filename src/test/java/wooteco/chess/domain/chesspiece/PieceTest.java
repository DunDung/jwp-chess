package wooteco.chess.domain.chesspiece;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import wooteco.chess.domain.Team;
import wooteco.chess.domain.position.Position;

public class PieceTest {
	private Piece pawn;

	@BeforeEach
	void setUp() {
		pawn = new Pawn(Position.of(2, 2), Team.BLACK);
	}

	@Test
	void isBlankPieceTest() {
		Piece blank = new Blank(Position.of(1, 1));

		assertThat(blank.isBlankPiece()).isTrue();
	}

	@Test
	void isNotBlankPieceTest() {
		assertThat(pawn.isNotBlankPiece()).isTrue();
	}

	@Test
	void isMatchTeamTest() {
		assertThat(pawn.isMatchTeam(Team.BLACK)).isTrue();
		assertThat(pawn.isMatchTeam(Team.WHITE)).isFalse();
	}

	@Test
	void isNotMatchTeam() {
		assertThat(pawn.isNotMatchTeam(Team.WHITE)).isTrue();
		assertThat(pawn.isNotMatchTeam(Team.BLACK)).isFalse();
	}

	@Test
	void isSameTeamTest() {
		Piece blackTeamKing = new King(Position.of(2, 2), Team.BLACK);
		Piece whiteTeamKing = new King(Position.of(2, 2), Team.WHITE);

		assertThat(pawn.isSameTeam(blackTeamKing)).isTrue();
		assertThat(pawn.isSameTeam(whiteTeamKing)).isFalse();

	}

	@Test
	void equalsPositionTest() {
		assertThat(pawn.equalsPosition(Position.of(2, 2))).isTrue();
	}

}

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InGameController {

    InGameView _view;
    InGameData _data;

    public InGameController(){

        _view = GameManager.getInstance().get_inGame();
        _data = GameManager.getInstance().get_gameData();

        for(Pawn p:_data.leftPlayer.pawns) {
            //_view.add(p);
            p.addMouseListener(new PawnClickListener());
        }
        for(Pawn p:_data.rightPlayer.pawns) {
            //_view.add(p);
            p.addMouseListener(new PawnClickListener());
        }

    }

    private class PawnClickListener implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseClicked(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }
    }

    private class FocusedPawnMove implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int preview;
            if(_data.activatedPlayer == _data.leftPlayer){

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
package it.polimi.ingsw.network.Message;

public class RequestIsExpert extends ClientToServer{
        private static final long serialVersionUID= -6929509489095279482L;

        private final boolean isExpert;

        public RequestIsExpert(boolean isExpert){

            this.isExpert = isExpert;
        }

        public boolean getIsExpert(){
            return isExpert;
        }
}

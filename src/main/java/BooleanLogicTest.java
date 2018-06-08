public class BooleanLogicTest {

    public static class Channel {
        public Boolean isEntitled;
        public Boolean isReceived;
    }

    public static void main(String[] args) {
        Channel channel = new Channel();
        channel.isEntitled = true;
        channel.isReceived = true;
        boolean hasEntitled = channel.isEntitled != null;
        boolean hasReceived = channel.isReceived != null;
        boolean isReceived = true;
        if (hasEntitled && hasReceived) {
            isReceived = channel.isEntitled && channel.isReceived;
        } else if (hasEntitled) {
            isReceived = channel.isEntitled;
        } else if (hasReceived) {
            isReceived = channel.isReceived;
        }

        boolean isReceivedCalculatedDifferently = channel.isEntitled || channel.isReceived;
        System.out.println(isReceived + " vs " + isReceivedCalculatedDifferently);
    }
}

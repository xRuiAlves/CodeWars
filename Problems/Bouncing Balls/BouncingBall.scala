object BouncingBall {
    def bouncingBall(h: Double, bounce: Double, window: Double): Int = {
        if (valid(h, bounce, window)) getViewCount(h, bounce, window) else -1
    }

    def valid(h: Double, bounce: Double, window: Double): Boolean = h > 0 &&
        bounce > 0 && bounce < 1 &&
        window < h

    def getViewCount(h: Double, bounce: Double, window: Double): Int = {
        var count = 1
        var curr_h = h * bounce

        while (curr_h > window) {
            count += 2
            curr_h = curr_h * bounce
        }
        count
    }
}
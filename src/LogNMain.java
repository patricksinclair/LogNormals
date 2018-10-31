import org.apache.commons.math3.distribution.*;

import java.util.Random;

public class LogNMain {
    public static void main(String[] args){
        Double mu = 0.2;
        Double sigma = 0.0;
        Random rand = new Random();
        LogNormalDistribution logNormal = new LogNormalDistribution(sigma, mu);
        String filename = "lognormal-samples_mu="+String.valueOf(mu)+"_sigma="+String.valueOf(sigma);
        String filename_cuProb = "cumulProbs_mu="+String.valueOf(mu)+"_sigma="+String.valueOf(sigma);
        String filename_invCuProb = "inverseCumulProbs_mu="+String.valueOf(mu)+"_sigma="+String.valueOf(sigma);

        int N_points = (int)1e6;

        //System.out.println(logNormal.cumulativeProbability());

        double[] log_norms = new double[N_points];
        double[] cuPr_x = new double[N_points];
        double[] cuPr_y = new double[N_points];
        double[] invCuPr_x = new double[N_points];
        double[] invCuPr_y = new double[N_points];

        for(int i = 0; i < N_points; i++) {
            log_norms[i] = logNormal.sample();
            double x = 2.25*rand.nextDouble(); //2.25 here is hard coded in for the mo
            cuPr_x[i] = x;
            cuPr_y[i] = logNormal.cumulativeProbability(x);

            double r = rand.nextDouble();
            invCuPr_x[i] = r;
            invCuPr_y[i] = logNormal.inverseCumulativeProbability(r);
        }

        Toolbox.write1DArrayToFile(filename, log_norms);
        Toolbox.write_2_1DArraysToFile(filename_cuProb, cuPr_x, cuPr_y);
        Toolbox.write_2_1DArraysToFile(filename_invCuProb, invCuPr_x, invCuPr_y);

    }
}

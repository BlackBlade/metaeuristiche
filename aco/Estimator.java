package aco;

import java.util.LinkedList;
import java.util.List;

public class Estimator implements ArcEstimator {
	
	private static final double alpha = 1.0;
	private static final double beta = 2.0;
	private static final double evaporation_rate = 0.5;
	private int[] etha; //nel caso di BPP, etha è il peso dell'oggetto
	private double contributes[][];
	private int spaceSize;
	private double bestCost;
	private List<Bin> bestSolution;
	
	public Estimator(int spaceSize){
		this.contributes = new double[spaceSize][spaceSize];
		this.etha = new int[spaceSize];
		this.spaceSize = spaceSize;
		this.bestCost = Double.MAX_VALUE;
		this.bestSolution = new LinkedList<>();
		for(Integer i : InitializeBPP.model.getItemSet())
			etha[i] = InitializeBPP.model.getObjects().get(i);
	}

	@Override
	public double getAlpha() {
		return alpha;
	}

	@Override
	public double getBeta() {
		return beta;
	}

	@Override
	public double getEvapRate() {
		return evaporation_rate;
	}
	
	public int[] getEtha() {
		return etha;
	}
	
	public double getContribute(int index1, int index2){ //get tau matrix
		return this.contributes[index1][index2];
	}

	/**
	 * Modifies contributes according to the solution of each single ant.
	 * */
	
	
	//Equazione (7)
	/*public void localUpdateRule(List<Integer> solution) {
		//To calculate the contributes
		double cost = 0.0;
		for(int i=0; i<solution.size()-1; i++){
			//Ant.getNumBin
			//cost+= arcWeight[solution.get(i)][solution.get(i+1)]; //ottengo il costo della soluzione trovata
		}
		
		//cost � il numero di bin 
		if (cost<bestCost){
			bestCost=cost;
			this.bestSolution = solution;
		}
		//Trovato il costo, lo aggiungo alla matrice dei contributi
		for(int i=0; i<solution.size()-1; i++){
			contributes[solution.get(i)][solution.get(i+1)]+=1/cost; //regola per TSP
			//contributes[solution.get(i)][solution.get(i+1)]+=1/numBin
			}
		
	}*/
	
	
	
	@Override
	public double getBestSolutionCost(){
		return this.bestCost;
	}
	
	@Override
	public List<Bin> getBestSolution(){
		return this.bestSolution;
	}

	@Override
	public void localUpdateRule(AntSolution solution) {
		/*
		int cost = solution.size();
		
		if (cost<bestCost){
			bestCost=cost;
			this.bestSolution = solution;
		}
		
		for(Bin b : solution){
			for (int i = 0; i< InitializeBPP.model.getObjects().size(); i++){
				
				}
			}
		
		
		*/
	}

}

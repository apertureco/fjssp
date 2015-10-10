package com.mnmlist.jsp;

import java.util.Random;

/**
 * @author mnmlist@163.com
 * @blog http://blog.csdn.net/mnmlist
 * @version v1.0
 */
public class GenerateDNA {
	/**
	 * @param jobCount 
	 * @param dna the DNA sequence
	 * @param entries include the jobNo and the procedureNo
	 * @param dnaLength
	 */
	public static void generateOneDNA(int jobCount, int[] dna, entry[] entries,
			int dnaLength) {
		// entries �����������Ӧ�Ĺ�����
		int i = 0;
		int tempjobCount = jobCount;
		Random generator = new Random();
		int randomRange = 32767;
		int ran = 0;
		for (i = 0; i < dnaLength; i++) {
			ran = generator.nextInt(randomRange) % tempjobCount;// containerSize��jobcount;
			dna[i] = entries[ran].index;// ÿ�β���һ������
			entries[ran].value--;// �����������Ӧ�Ĺ�������һ����ʣ��Ĺ�����Ŀ��һ
			if (entries[ran].value == 0) {
				// ������ĿΪ0ʱ��˵���ù��ֵ����й����Ѿ�����
				tempjobCount--;// ������Ŀ
				entries[ran].index = entries[tempjobCount].index;// ɾ��������ĿΪ0���Ǹ�����
				entries[ran].value = entries[tempjobCount].value;// ͨ�������һ�����ּ����Ӧ�Ĺ�����Ŀ���蹤����ĿΪ0�ı�����ʵ��
			}
		}
	}

	/**
	 * @param jobCount
	 * @param populationSize 
	 * @param dnaArray the DNA sequence of the whole population
	 * @param entries include the jobNo and the procedureNo
	 * @param dnaLength
	 */
	public static void generateDNAs(int jobCount, int populationSize,
			int[][] dnaArray, entry[] entries, int dnaLength) {
		// entries �����������Ӧ�Ĺ�����
		int i = 0;
		entry[] tempEntries = new entry[jobCount];
		for (int q = 0; q < jobCount; q++) {
			tempEntries[q] = new entry();
		}
		for (; i < populationSize; i++) {
			for (int p = 0; p < jobCount; p++) {
				tempEntries[p].index = entries[p].index;
				tempEntries[p].value = entries[p].value;
			}
			generateOneDNA(jobCount, dnaArray[i], tempEntries, dnaLength);
		}
	}
}
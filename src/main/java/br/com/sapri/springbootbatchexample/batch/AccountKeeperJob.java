package br.com.sapri.springbootbatchexample.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import br.com.sapri.springbootbatchexample.entity.Users;

@Component
public class AccountKeeperJob extends JobExecutionListenerSupport {

	@Autowired
	JobBuilderFactory jobBuilderFactory;

	@Autowired
	StepBuilderFactory stepBuilderFactory;

	@Autowired
	Processor processor;

	@Autowired
	Writer writer;

	@Value("${input.file}")
	Resource resource;

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("START JOB");
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("FINISH JOB SUCCESSFUL");
	}


	@Bean(name = "accountJob")
	public Job accountKeeperJob() {
		Step step = this.stepBuilderFactory.get("step-1")
								.<Users, Users>chunk(6600)
								.reader(new Reader(resource))
								.processor(this.processor)
								.writer(this.writer)
								.build();
		
		Job job = this.jobBuilderFactory.get("accounting-job")
								.incrementer(new RunIdIncrementer())
								.listener(this)
								.start(step)
								.build();
		
		return job;
	}
}

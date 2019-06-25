package com.example.ktablejoin;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.kstream.Joined;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding({JoinSampleApplication.KStreamKTableBinding.class, Sink.class})
public class JoinSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoinSampleApplication.class);
	}

	@StreamListener
	@SendTo("t3_joined_out")
	public KStream<Integer, MyValueContainer> process(
			@Input("t2_cashflow_stream_in") KStream<Integer, Cashflow> cashflowStream,
			@Input("t2_contract_stream_in") KTable<Integer, Contract> contractTable) {

		return  cashflowStream
				.leftJoin(contractTable,
						MyValueContainer::new,
						Joined.with(Serdes.Integer(), new JsonSerde<>(Cashflow.class), new JsonSerde<>(Contract.class)));
	}

	@StreamListener("input")
	public void readFromKStreamProcessorOutput(MyValueContainer myValueContainer) {
		System.out.println("Joined Cashflow/Contract details");
		System.out.println("---------------------------------");
		System.out.println(myValueContainer.getCashflow());
		System.out.println(myValueContainer.getContract());
		System.out.println("---------------------------------");
	}


	public interface KStreamKTableBinding {

		@Input("t2_cashflow_stream_in")
		KStream<?, ?> t2_cashflow_stream_in();

		@Input("t2_contract_stream_in")
		KTable<?, ?> t2_contract_stream_in();

		@Output("t3_joined_out")
		KStream<?, ?> t3_joined_out();
	}
}

